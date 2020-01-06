/*     */ package com.zyzhou.agent;
/*     */ 
/*     */ import com.zyzhou.agent.a.a;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.Date;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class c
/*     */ {
/*  31 */   private static final Logger a = Logger.getLogger(c.class);
/*     */ 
/*     */   public static boolean a(b task, MonitorConfig config)
/*     */   {
/*  50 */     if (("MONITOR".equalsIgnoreCase(task.a())) || 
/*  51 */       ("MONITOR_LIGHTON".equalsIgnoreCase(task.a())) || 
/*  52 */       ("MONITOR_LIGHTOFF".equalsIgnoreCase(task.a()))) {
/*  53 */       task.c(new Date());
/*  54 */       String mailBody = a(config);
/*     */ 
/*  56 */       String photoPath = null;
/*     */       try {
/*  58 */         photoPath = b(config);
/*     */       } catch (Exception e) {
/*  60 */         mailBody = mailBody + "\r\n获取图片失败，信息为:" + e.getMessage();
/*     */       }
/*     */ 
/*  63 */       if ("MONITOR_LIGHTON".equalsIgnoreCase(task.a()))
/*  64 */         c(config);
/*  65 */       else if ("MONITOR_LIGHTOFF".equalsIgnoreCase(task.a())) {
/*  66 */         d(config);
/*     */       }
/*     */ 
/*  69 */       task.e("monitor result");
/*     */ 
/*  71 */       task.f(mailBody);
/*     */       File file;
/*  73 */       if (photoPath != null) {
/*  74 */         file = new File(photoPath);
/*  75 */         task.a(new File[] { file });
/*  76 */         task.a(new String[] { file.getName() });
/*     */       }
/*  78 */       task.d(new Date());
/*     */ 
/*  81 */       if (a.a(task, config))
/*  82 */         a.info("发送邮件成功,MonitorTask=" + task.toString());
/*     */       else {
/*  84 */         a.info("发送邮件失败,MonitorTask=" + task.toString());
/*     */       }
/*     */ 
/*  87 */       if (photoPath != null) {
/*  88 */         (
/*  89 */           file = new File(photoPath))
/*  89 */           .delete();
/*     */       }
/*     */     }
/*  92 */     return true;
/*     */   }
/*     */ 
/*     */   private static String a(MonitorConfig config)
/*     */   {
/*     */     try
/*     */     {
/* 103 */       StringBuffer buf = new StringBuffer();
/* 104 */       String cmd = config.getTemperatureCmd();
/* 105 */       Process pr = Runtime.getRuntime().exec(cmd);
/* 106 */       BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream(), "GBK"));
/*     */       String line;
/* 108 */       while ((line = input.readLine()) != null) {
/* 109 */         buf.append(line + "\r\n");
/*     */       }
/* 111 */       pr.getInputStream().close();
/* 112 */       pr.waitFor();
/* 113 */       return buf.toString();
/*     */     }
/*     */     catch (Exception localException1)
/*     */     {
/*     */       Exception e;
/* 114 */       (
/* 115 */         e = localException1)
/* 115 */         .printStackTrace();
/* 116 */       a.info("getTemperature exception:" + e.getMessage());
/* 117 */       return "获取温度出现异常:" + e.getMessage();
/*     */     }
/*     */   }
/*     */ 
/*     */   private static String b(MonitorConfig config)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 134 */       String fileFullPath = config.getPhotoPath();
/* 135 */       String cmd = config.getPhotoCmd();
/* 136 */       (
/* 137 */         cmd = Runtime.getRuntime().exec(cmd))
/* 137 */         .waitFor();
/*     */ 
/* 139 */       if ((
/* 139 */         cmd = new File(fileFullPath))
/* 139 */         .exists()) {
/* 140 */         return fileFullPath;
/*     */       }
/* 142 */       throw new Exception("文件" + fileFullPath + "不存在");
/*     */     }
/*     */     catch (Exception localException1)
/*     */     {
/*     */       Exception e;
/* 144 */       (
/* 145 */         e = localException1)
/* 145 */         .printStackTrace();
/* 146 */       a.info("getPhoto exception:" + e.getMessage());
/* 147 */       throw e;
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void c(MonitorConfig config)
/*     */   {
/*     */     try
/*     */     {
/* 160 */       String cmd = config.getLightOnCmd();
/* 161 */       Process pr = Runtime.getRuntime().exec(cmd);
/* 162 */       BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream(), "GBK"));
/* 163 */       StringBuffer buf = new StringBuffer();
/*     */       String line;
/* 165 */       while ((line = input.readLine()) != null) {
/* 166 */         buf.append(line + "\r\n");
/*     */       }
/* 168 */       pr.getInputStream().close();
/* 169 */       pr.waitFor();
/* 170 */       a.info("turnOn result:" + buf.toString());
/*     */       return;
/*     */     }
/*     */     catch (Exception localException1)
/*     */     {
/*     */       Exception e;
/* 171 */       (
/* 172 */         e = localException1)
/* 172 */         .printStackTrace();
/* 173 */       a.info("turnOn exception:" + e.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void d(MonitorConfig config)
/*     */   {
/*     */     try
/*     */     {
/* 185 */       String cmd = config.getLightOffCmd();
/* 186 */       Process pr = Runtime.getRuntime().exec(cmd);
/* 187 */       BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream(), "GBK"));
/* 188 */       StringBuffer buf = new StringBuffer();
/*     */       String line;
/* 190 */       while ((line = input.readLine()) != null) {
/* 191 */         buf.append(line + "\r\n");
/*     */       }
/* 193 */       pr.getInputStream().close();
/* 194 */       pr.waitFor();
/* 195 */       a.info("turnOff result:" + buf.toString());
/*     */       return;
/*     */     }
/*     */     catch (Exception localException1)
/*     */     {
/*     */       Exception e;
/* 196 */       (
/* 197 */         e = localException1)
/* 197 */         .printStackTrace();
/* 198 */       a.info("turnOff exception:" + e.getMessage());
/*     */     }
/*     */   }
/*     */ }

/* Location:           H:\New\monitor\monitor.jar
 * Qualified Name:     com.zyzhou.agent.c
 * JD-Core Version:    0.6.2
 */