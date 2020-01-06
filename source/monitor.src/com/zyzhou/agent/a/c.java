/*      */ package com.zyzhou.agent.a;
/*      */ 
/*      */ import com.thoughtworks.xstream.XStream;
/*      */ import com.thoughtworks.xstream.converters.basic.DateConverter;
/*      */ import com.thoughtworks.xstream.io.xml.DomDriver;
/*      */ import java.io.File;
/*      */ import java.security.MessageDigest;
/*      */ import java.util.Arrays;
/*      */ import java.util.Date;
/*      */ import java.util.TimeZone;
/*      */ import javax.activation.DataHandler;
/*      */ import javax.activation.FileDataSource;
/*      */ import javax.mail.BodyPart;
/*      */ import javax.mail.Message;
/*      */ import javax.mail.Message.RecipientType;
/*      */ import javax.mail.Multipart;
/*      */ import javax.mail.Session;
/*      */ import javax.mail.internet.InternetAddress;
/*      */ import javax.mail.internet.MimeBodyPart;
/*      */ import javax.mail.internet.MimeMessage;
/*      */ import javax.mail.internet.MimeMultipart;
/*      */ import javax.mail.internet.MimeUtility;
/*      */ 
/*      */ public class c
/*      */ {
/*      */   private static c a;
/*      */ 
/*      */   public static c a()
/*      */   {
/*   50 */     if (a == null) {
/*   51 */       a = new c();
/*      */     }
/*   53 */     return a;
/*      */   }
/*      */ 
/*      */   public final Message a(Session sess, String from, String to, String subject, String body, File[] atts, String[] attNames, String sendType, String cc, String bcc)
/*      */     throws Exception
/*      */   {
/*      */     String bcc;
/*      */     String cc;
/*      */     String sendType;
/*      */     String[] attNames;
/*      */     File[] atts;
/*  126 */     if (atts == null) {
/*  127 */       sendType = 
/*  128 */         null;
/*      */ 
/*  127 */       attNames = 
/*  128 */         null;
/*      */ 
/*  127 */       atts = null; body = body; subject = subject; to = to; from = from; sess = sess;
/*      */ 
/* 1077 */       (
/* 1079 */         sess = new MimeMessage(sess))
/* 1079 */         .setFrom(new InternetAddress(from));
/* 1080 */       sess.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
/* 1081 */       if ((attNames != null) && (attNames.trim().length() > 0)) {
/* 1082 */         sess.addRecipients(Message.RecipientType.CC, 
/* 1083 */           InternetAddress.parse(attNames));
/*      */       }
/* 1085 */       if ((sendType != null) && (sendType.trim().length() > 0)) {
/* 1086 */         sess.addRecipients(Message.RecipientType.BCC, 
/* 1087 */           InternetAddress.parse(sendType));
/*      */       }
/* 1089 */       sess.setSentDate(new Date());
/* 1090 */       sess.setSubject(subject);
/*      */ 
/* 1093 */       if ((body != null) && (!body.trim().equals(""))) {
/* 1094 */         if ((atts != null) && (atts.equals("html")))
/* 1095 */           sess.setContent(body, "text/html;charset=gb2312");
/*      */         else {
/* 1097 */           sess.setText(body);
/*      */         }
/*      */       }
/*      */ 
/* 1101 */       sess.saveChanges();
/*      */ 
/*  127 */       return 
/* 1103 */         sess;
/*      */     }
/*  130 */     (
/*  133 */       msg = new MimeMessage(sess))
/*  133 */       .setFrom(new InternetAddress(from));
/*  134 */     msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
/*      */ 
/*  143 */     msg.setSentDate(new Date());
/*  144 */     msg.setSubject(subject);
/*      */ 
/*  146 */     mm = new MimeMultipart();
/*      */ 
/*  148 */     if ((body != null) && (!body.trim().equals("")))
/*      */     {
/*  150 */       (
/*  155 */         mbp = new MimeBodyPart())
/*  155 */         .setContent(body, "text/plain;charset=gb2312");
/*      */ 
/*  158 */       mm.addBodyPart(mbp);
/*      */     }
/*      */ 
/*  162 */     for (i = 0; i < atts.length; i++) {
/*  163 */       mbp = new MimeBodyPart();
/*  164 */       FileDataSource fds = new FileDataSource(atts[i]);
/*  165 */       DataHandler dh = new DataHandler(fds);
/*  166 */       if (attNames != null)
/*      */       {
/*  168 */         mbp.setFileName(MimeUtility.encodeWord(attNames[i], "GB2312", 
/*  169 */           null));
/*      */       }
/*  171 */       else mbp.setFileName(MimeUtility.encodeWord(atts[i].getName(), 
/*  172 */           "GB2312", null));
/*  173 */       mbp.setDataHandler(dh);
/*  174 */       mm.addBodyPart(mbp);
/*      */     }
/*      */ 
/*  177 */     msg.setContent(mm);
/*  178 */     msg.saveChanges();
/*  179 */     return msg;
/*      */   }
/*      */ 
/*      */   public static boolean a(String input, String signature)
/*      */     throws Exception
/*      */   {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ifnonnull +5 -> 6
/*      */     //   4: iconst_0
/*      */     //   5: ireturn
/*      */     //   6: aload_0
/*      */     //   7: invokevirtual 50	java/lang/String:getBytes	()[B
/*      */     //   10: astore_0
/*      */     //   11: aload_1
/*      */     //   12: invokevirtual 50	java/lang/String:getBytes	()[B
/*      */     //   15: astore_1
/*      */     //   16: bipush 12
/*      */     //   18: newarray byte
/*      */     //   20: astore_2
/*      */     //   21: aload_1
/*      */     //   22: iconst_0
/*      */     //   23: aload_2
/*      */     //   24: iconst_0
/*      */     //   25: bipush 12
/*      */     //   27: invokestatic 53	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
/*      */     //   30: ldc 4
/*      */     //   32: invokestatic 55	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
/*      */     //   35: dup
/*      */     //   36: astore_3
/*      */     //   37: aload_2
/*      */     //   38: invokevirtual 56	java/security/MessageDigest:update	([B)V
/*      */     //   41: aload_3
/*      */     //   42: aload_0
/*      */     //   43: invokevirtual 56	java/security/MessageDigest:update	([B)V
/*      */     //   46: aload_3
/*      */     //   47: invokevirtual 54	java/security/MessageDigest:digest	()[B
/*      */     //   50: astore_0
/*      */     //   51: iconst_0
/*      */     //   52: istore_2
/*      */     //   53: goto +43 -> 96
/*      */     //   56: aload_0
/*      */     //   57: iload_2
/*      */     //   58: dup2
/*      */     //   59: baload
/*      */     //   60: bipush 16
/*      */     //   62: iadd
/*      */     //   63: i2b
/*      */     //   64: bastore
/*      */     //   65: aload_0
/*      */     //   66: iload_2
/*      */     //   67: baload
/*      */     //   68: bipush 65
/*      */     //   70: if_icmplt -14 -> 56
/*      */     //   73: goto +12 -> 85
/*      */     //   76: aload_0
/*      */     //   77: iload_2
/*      */     //   78: dup2
/*      */     //   79: baload
/*      */     //   80: bipush 16
/*      */     //   82: isub
/*      */     //   83: i2b
/*      */     //   84: bastore
/*      */     //   85: aload_0
/*      */     //   86: iload_2
/*      */     //   87: baload
/*      */     //   88: bipush 122
/*      */     //   90: if_icmpgt -14 -> 76
/*      */     //   93: iinc 2 1
/*      */     //   96: iload_2
/*      */     //   97: aload_0
/*      */     //   98: arraylength
/*      */     //   99: if_icmplt -34 -> 65
/*      */     //   102: aload_1
/*      */     //   103: arraylength
/*      */     //   104: bipush 12
/*      */     //   106: isub
/*      */     //   107: newarray byte
/*      */     //   109: astore_2
/*      */     //   110: aload_1
/*      */     //   111: bipush 12
/*      */     //   113: aload_2
/*      */     //   114: iconst_0
/*      */     //   115: aload_1
/*      */     //   116: arraylength
/*      */     //   117: bipush 12
/*      */     //   119: isub
/*      */     //   120: invokestatic 53	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
/*      */     //   123: aload_0
/*      */     //   124: aload_2
/*      */     //   125: invokestatic 57	java/util/Arrays:equals	([B[B)Z
/*      */     //   128: ifeq +5 -> 133
/*      */     //   131: iconst_1
/*      */     //   132: ireturn
/*      */     //   133: iconst_0
/*      */     //   134: ireturn
/*      */   }
/*      */ 
/*      */   public static Object a(String xml, Class type)
/*      */     throws Exception
/*      */   {
/*      */     XStream xs;
/* 3046 */     XStream localXStream1 = xs = new XStream(new DomDriver());
/*      */ 
/* 3084 */     TimeZone localTimeZone = TimeZone.getTimeZone("GMT+8");
/* 3085 */     localXStream1.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", 
/* 3086 */       new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm", 
/* 3087 */       "yyyy-MM-ddTHH:mm:ss" }, localTimeZone));
/*      */ 
/* 3047 */     xs.processAnnotations(type);
/* 3048 */     return xs.fromXML(xml);
/*      */   }
/*      */ }

/* Location:           H:\New\monitor\monitor.jar
 * Qualified Name:     com.zyzhou.agent.a.c
 * JD-Core Version:    0.6.2
 */