/*     */ package com.zyzhou.agent;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class a
/*     */ {
/*  34 */   private static final Logger a = Logger.getLogger(a.class);
/*     */ 
/*     */   public static void a()
/*     */   {
/*  48 */     a.info("MonitorAgentUtil starts");
/*     */ 
/*  50 */     a.info("初始化MonitorConfig");
/*     */     Object config;
/*     */     try
/*     */     {
/* 1099 */       Object localObject1 = com.zyzhou.a.b.a(localObject1 = "config/MonitorConfig.xml");
/*     */ 
/* 1100 */       Object localObject2 = MonitorConfig.class;
/*     */ 
/* 1102 */       if ((
/* 1102 */         localObject1 = (MonitorConfig)com.zyzhou.agent.a.c.a((String)localObject1, (Class)localObject2)) != null)
/*     */       {
/* 1104 */         if (!com.zyzhou.agent.a.c.a(localObject2 = ((MonitorConfig)localObject1).getDeviceMailAddr() + "#@" + ((MonitorConfig)localObject1).getDeviceId() + "&$" + ((MonitorConfig)localObject1).getMasterMailAddr(), 
/* 1104 */           ((MonitorConfig)localObject1).getSignature())) {
/* 1105 */           a.info("checkSignature fail");
/* 1106 */           localObject1 = null;
/*     */         }
/*     */       }
/*  53 */       config = 
/* 1109 */         localObject1;
/*     */ 
/*  54 */       a.info("初始化MonitorConfig成功,MonitorConfig:" + ((MonitorConfig)config).toString());
/*     */     } catch (Exception e) {
/*  56 */       a.info("初始化MonitorConfig失败:" + e.getMessage());
/*  57 */       config = null;
/*     */     }
/*     */ 
/*  60 */     if (config != null)
/*     */     {
/*     */       Object mailList;
/*  64 */       if ((
/*  64 */         mailList = com.zyzhou.agent.a.a.a((MonitorConfig)config))
/*  64 */         .size() == 0) {
/*  65 */         a.info("mailList empty");
/*     */       } else {
/*  67 */         a.info("需要处理的邮件共" + ((List)mailList).size() + "封,详细信息如下:");
/*  68 */         for (com.zyzhou.agent.a.b mailInfo : (List)mailList) {
/*  69 */           a.info(mailInfo.toString());
/*     */         }
/*     */ 
/*  72 */         List taskList = a((List)mailList, (MonitorConfig)config);
/*  73 */         a.info("需要处理的任务共" + taskList.size() + "个,详细信息如下:");
/*  74 */         for (mailList = taskList.iterator(); ((Iterator)mailList).hasNext(); ) { b task = (b)((Iterator)mailList).next();
/*  75 */           a.info(task.toString());
/*     */         }
/*  77 */         for (mailList = taskList.iterator(); ((Iterator)mailList).hasNext(); )
/*     */         {
/*     */           b task;
/*  79 */           c.a(task = (b)((Iterator)mailList).next(), 
/*  79 */             (MonitorConfig)config);
/*  80 */           a.info("MonitorTask success：" + task.toString());
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  87 */     a.info("MonitorAgentUtil ends");
/*     */   }
/*     */ 
/*     */   private static List<b> a(List<com.zyzhou.agent.a.b> mailList, MonitorConfig config)
/*     */   {
/*     */     MonitorConfig config;
/* 140 */     List taskList = new ArrayList();
/*     */     try {
/* 142 */       for (Iterator localIterator = mailList.iterator(); localIterator.hasNext(); )
/*     */       {
/* 144 */         if (((
/* 144 */           mailInfo = (com.zyzhou.agent.a.b)localIterator.next())
/* 144 */           .b().equalsIgnoreCase(config.getDeviceMailAddr())) && 
/* 145 */           (mailInfo.a().equalsIgnoreCase(config.getMasterMailAddr()))) {
/* 146 */           if (config.getDeviceId().equalsIgnoreCase(mailInfo.c()))
/*     */           {
/*     */             b task;
/* 147 */             (
/* 148 */               task = new b())
/* 148 */               .a(mailInfo.d());
/* 149 */             task.b(new Date());
/* 150 */             task.c(config.getDeviceMailAddr());
/* 151 */             task.d(config.getMasterMailAddr());
/* 152 */             task.b("MONITOR");
/* 153 */             taskList.add(task);
/* 154 */           } else if ((config.getDeviceId() + " on").equalsIgnoreCase(mailInfo.c()))
/*     */           {
/*     */             b task;
/* 155 */             (
/* 156 */               task = new b())
/* 156 */               .a(mailInfo.d());
/* 157 */             task.b(new Date());
/* 158 */             task.c(config.getDeviceMailAddr());
/* 159 */             task.d(config.getMasterMailAddr());
/* 160 */             task.b("MONITOR_LIGHTON");
/* 161 */             taskList.add(task);
/* 162 */           } else if ((config.getDeviceId() + " off").equalsIgnoreCase(mailInfo.c()))
/*     */           {
/*     */             b task;
/* 163 */             (
/* 164 */               task = new b())
/* 164 */               .a(mailInfo.d());
/* 165 */             task.b(new Date());
/* 166 */             task.c(config.getDeviceMailAddr());
/* 167 */             task.d(config.getMasterMailAddr());
/* 168 */             task.b("MONITOR_LIGHTOFF");
/* 169 */             taskList.add(task);
/*     */           }
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 175 */           a.info("邮件不合条件,MailInfo=" + mailInfo.toString() + ",MonitorConfig=" + config.toString());
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 179 */       a.info("convertMailListToTaskList exception:" + e.getMessage());
/*     */     }
/* 181 */     return taskList;
/*     */   }
/*     */ }

/* Location:           H:\New\monitor\monitor.jar
 * Qualified Name:     com.zyzhou.agent.a
 * JD-Core Version:    0.6.2
 */