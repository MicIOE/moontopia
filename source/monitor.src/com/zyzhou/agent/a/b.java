/*    */ package com.zyzhou.agent.a;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public final class b
/*    */ {
/*    */   private String a;
/*    */   private String b;
/*    */   private String c;
/*    */   private Date d;
/*    */   private Date e;
/*    */ 
/*    */   public final String a()
/*    */   {
/* 58 */     return this.a;
/*    */   }
/*    */   public final void a(String from) {
/* 61 */     this.a = from;
/*    */   }
/*    */   public final String b() {
/* 64 */     return this.b;
/*    */   }
/*    */   public final void b(String to) {
/* 67 */     this.b = to;
/*    */   }
/*    */   public final String c() {
/* 70 */     return this.c;
/*    */   }
/*    */   public final void c(String subject) {
/* 73 */     this.c = subject;
/*    */   }
/*    */   public final Date d() {
/* 76 */     return this.d;
/*    */   }
/*    */   public final void a(Date sentDate) {
/* 79 */     this.d = sentDate;
/*    */   }
/*    */ 
/*    */   public final void b(Date receivedDate)
/*    */   {
/* 85 */     this.e = receivedDate;
/*    */   }
/*    */ 
/*    */   public final String toString()
/*    */   {
/*    */     StringBuffer buf;
/* 89 */     (
/* 90 */       buf = new StringBuffer())
/* 90 */       .append("from=" + this.a + ",");
/* 91 */     buf.append("to=" + this.b + ",");
/* 92 */     buf.append("subject=" + this.c + ",");
/* 93 */     buf.append("sentDate=" + this.d + ",");
/* 94 */     buf.append("receivedDate=" + this.e + "\r\n");
/*    */ 
/* 96 */     return buf.toString();
/*    */   }
/*    */ }

/* Location:           H:\New\monitor\monitor.jar
 * Qualified Name:     com.zyzhou.agent.a.b
 * JD-Core Version:    0.6.2
 */