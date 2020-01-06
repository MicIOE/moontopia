/*     */ package com.zyzhou.agent.a;
/*     */ 
/*     */ import com.zyzhou.agent.MonitorConfig;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import javax.mail.Address;
/*     */ import javax.mail.Flags.Flag;
/*     */ import javax.mail.Folder;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.MessagingException;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Store;
/*     */ import javax.mail.Transport;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class a
/*     */ {
/*  21 */   private static final Logger a = Logger.getLogger(a.class);
/*     */ 
/*     */   public static boolean a(com.zyzhou.agent.b task, MonitorConfig config)
/*     */   {
/*     */     try
/*     */     {
/*     */       Properties cfgMailProps;
/*  46 */       (
/*  47 */         cfgMailProps = new Properties())
/*  47 */         .put("mail.smtp.host", config.getMailSmtpHost());
/*  48 */       cfgMailProps.put("mail.user", config.getMailUser());
/*  49 */       cfgMailProps.put("mail.password", config.getMailPassword());
/*  50 */       cfgMailProps.put("mail.transport.protocol", config.getMailTransportProtocol());
/*  51 */       cfgMailProps.put("mail.smtp.port", Integer.valueOf(config.getMailSmtpPort()));
/*  52 */       cfgMailProps.put("mail.smtp.auth", config.getMailSmtpAuth());
/*  53 */       cfgMailProps.put("mail.debug", config.getMailDebug());
/*  54 */       cfgMailProps.put("mail.store.protocol", config.getMailStoreProtocol());
/*  55 */       cfgMailProps.put("mail.store.port", Integer.valueOf(config.getMailStorePort()));
/*     */ 
/*  58 */       cfgMailProps.put("mail.smtp.timeout", Integer.valueOf(config.getSoTimeout()));
/*  59 */       cfgMailProps.put("mail.smtp.connectiontimeout", Integer.valueOf(config.getConnectionTimeout()));
/*     */ 
/*  62 */       Session mailSession = Session.getDefaultInstance(cfgMailProps);
/*     */       c localc;
/*  66 */       Message msg = (
/*  66 */         localc = c.a())
/*  66 */         .a(mailSession, task.b(), task.c(), 
/*  67 */         task.d(), task.e(), task.f(), task.g(), null, null, null);
/*     */       Transport transport;
/*  70 */       (
/*  71 */         transport = mailSession.getTransport(config.getMailTransportProtocol()))
/*  71 */         .connect(config.getMailSmtpHost(), config.getMailUser(), config.getMailPassword());
/*  72 */       transport.sendMessage(msg, msg.getAllRecipients());
/*  73 */       transport.close();
/*     */ 
/*  75 */       task.a(true);
/*  76 */       task.a("发送邮件成功");
/*     */     }
/*     */     catch (Exception localException1)
/*     */     {
/*     */       Exception e;
/*  77 */       (
/*  78 */         e = localException1)
/*  78 */         .printStackTrace();
/*  79 */       a.info("sendMail exception:" + e.getMessage());
/*  80 */       task.a(false);
/*  81 */       task.a("发送邮件失败:" + e.getMessage());
/*  82 */       return false;
/*     */     }
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */   public static List<b> a(MonitorConfig config)
/*     */   {
/*  95 */     List list = new ArrayList();
/*     */     try
/*     */     {
/*     */       Properties cfgMailProps;
/*  97 */       (
/*  98 */         cfgMailProps = new Properties())
/*  98 */         .put("mail.pop3.host", config.getMailStoreHost());
/*  99 */       cfgMailProps.put("mail.pop3.port", Integer.valueOf(config.getMailStorePort()));
/*     */ 
/* 101 */       cfgMailProps.put("mail.user", config.getMailUser());
/* 102 */       cfgMailProps.put("mail.password", config.getMailPassword());
/* 103 */       cfgMailProps.put("mail.debug", config.getMailDebug());
/* 104 */       cfgMailProps.put("mail.store.protocol", config.getMailStoreProtocol());
/* 105 */       cfgMailProps.put("mail.store.port", Integer.valueOf(config.getMailStorePort()));
/*     */ 
/* 107 */       cfgMailProps.put("mail.pop3.timeout", Integer.valueOf(config.getSoTimeout()));
/* 108 */       cfgMailProps.put("mail.pop3.connectiontimeout", Integer.valueOf(config.getConnectionTimeout()));
/*     */ 
/* 111 */       Session mailSession = Session.getDefaultInstance(cfgMailProps);
/*     */ 
/* 113 */       Store store = null;
/* 114 */       Folder folder = null;
/*     */       try {
/* 116 */         (
/* 117 */           store = mailSession.getStore(config.getMailStoreProtocol()))
/* 117 */           .connect(config.getMailUser(), config.getMailPassword());
/*     */ 
/* 119 */         (
/* 120 */           folder = store.getFolder("INBOX"))
/* 120 */           .open(2);
/*     */ 
/* 123 */         for (i = config = folder.getMessageCount()
/* 123 */           ; i > 0; i--) {
/* 124 */           message = folder.getMessage(i);
/* 125 */           b mailInfo = new b();
/*     */           String from;
/* 128 */           if (((
/* 128 */             from = message.getFrom()[0].toString()) != null) && 
/* 128 */             (from.length() > 0) && 
/* 129 */             (from.indexOf("<") >= 0))
/* 130 */             from = from.substring(from.indexOf("<") + 1, from.indexOf(">"));
/*     */           String to;
/* 135 */           if (((
/* 135 */             to = message.getAllRecipients()[0].toString()) != null) && 
/* 135 */             (to.length() > 0) && 
/* 136 */             (to.indexOf("<") >= 0)) {
/* 137 */             to = to.substring(to.indexOf("<") + 1, to.indexOf(">"));
/*     */           }
/*     */ 
/* 140 */           mailInfo.a(from);
/* 141 */           mailInfo.b(to);
/* 142 */           mailInfo.a(message.getSentDate());
/* 143 */           mailInfo.b(message.getReceivedDate());
/* 144 */           mailInfo.c(message.getSubject());
/* 145 */           list.add(mailInfo);
/*     */ 
/* 147 */           message.setFlag(Flags.Flag.DELETED, true);
/*     */         }
/*     */       }
/*     */       catch (Exception localException1)
/*     */       {
/*     */         try
/*     */         {
/* 154 */           if (folder != null) {
/* 155 */             folder.close(true);
/*     */           }
/* 157 */           if (store == null) break label478;
/* 158 */           store.close();
/*     */         } catch (MessagingException localMessagingException1) {
/* 160 */           (
/* 161 */             message = localMessagingException1)
/* 161 */             .printStackTrace();
/*     */         }
/*     */       }
/*     */       finally
/*     */       {
/*     */         try
/*     */         {
/* 154 */           if (folder != null) {
/* 155 */             folder.close(true);
/*     */           }
/* 157 */           if (store != null)
/* 158 */             store.close();
/*     */         } catch (MessagingException localMessagingException2) {
/* 160 */           (
/* 161 */             message = localMessagingException2)
/* 161 */             .printStackTrace();
/*     */         }
/*     */       }
/*     */       try
/*     */       {
/* 154 */         if (folder != null) {
/* 155 */           folder.close(true);
/*     */         }
/* 157 */         if (store != null)
/* 158 */           store.close();
/*     */       } catch (MessagingException localMessagingException3) {
/* 160 */         (
/* 161 */           message = localMessagingException3)
/* 161 */           .printStackTrace();
/*     */       }
/*     */     }
/*     */     catch (Exception localException2)
/*     */     {
/*     */       Message message;
/* 165 */       (
/* 166 */         message = localException2)
/* 166 */         .printStackTrace();
/*     */     }
/* 168 */     label478: return list;
/*     */   }
/*     */ }

/* Location:           H:\New\monitor\monitor.jar
 * Qualified Name:     com.zyzhou.agent.a.a
 * JD-Core Version:    0.6.2
 */