/*     */ package com.zyzhou.agent;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Date;
/*     */ 
/*     */ public final class b
/*     */ {
/*     */   private String a;
/*     */   private Date b;
/*     */   private Date c;
/*     */   private Date d;
/*     */   private Date e;
/*     */   private String f;
/*     */   private String g;
/*     */   private String h;
/*     */   private String i;
/*     */   private File[] j;
/*     */   private String[] k;
/*     */   private boolean l;
/*     */   private String m;
/*     */ 
/*     */   public final void a(boolean result)
/*     */   {
/*  68 */     this.l = result;
/*     */   }
/*     */ 
/*     */   public final void a(String message)
/*     */   {
/*  76 */     this.m = message;
/*     */   }
/*     */ 
/*     */   public final String a() {
/*  80 */     return this.a;
/*     */   }
/*     */ 
/*     */   public final void b(String taskType) {
/*  84 */     this.a = taskType;
/*     */   }
/*     */ 
/*     */   public final void a(Date createDate)
/*     */   {
/*  92 */     this.b = createDate;
/*     */   }
/*     */ 
/*     */   public final void b(Date acceptDate)
/*     */   {
/* 100 */     this.c = acceptDate;
/*     */   }
/*     */ 
/*     */   public final void c(Date startDate)
/*     */   {
/* 108 */     this.d = startDate;
/*     */   }
/*     */ 
/*     */   public final void d(Date endDate)
/*     */   {
/* 116 */     this.e = endDate;
/*     */   }
/*     */ 
/*     */   public final String b() {
/* 120 */     return this.f;
/*     */   }
/*     */ 
/*     */   public final void c(String mailFrom) {
/* 124 */     this.f = mailFrom;
/*     */   }
/*     */ 
/*     */   public final String c() {
/* 128 */     return this.g;
/*     */   }
/*     */ 
/*     */   public final void d(String mailTo) {
/* 132 */     this.g = mailTo;
/*     */   }
/*     */ 
/*     */   public final String d() {
/* 136 */     return this.h;
/*     */   }
/*     */ 
/*     */   public final void e(String mailSubject) {
/* 140 */     this.h = mailSubject;
/*     */   }
/*     */ 
/*     */   public final String e() {
/* 144 */     return this.i;
/*     */   }
/*     */ 
/*     */   public final void f(String mailBody) {
/* 148 */     this.i = mailBody;
/*     */   }
/*     */ 
/*     */   public final File[] f() {
/* 152 */     return this.j;
/*     */   }
/*     */ 
/*     */   public final void a(File[] atts) {
/* 156 */     this.j = atts;
/*     */   }
/*     */ 
/*     */   public final String[] g() {
/* 160 */     return this.k;
/*     */   }
/*     */ 
/*     */   public final void a(String[] attNames) {
/* 164 */     this.k = attNames;
/*     */   }
/*     */ 
/*     */   public final String toString()
/*     */   {
/*     */     StringBuffer buf;
/* 169 */     (
/* 170 */       buf = new StringBuffer())
/* 170 */       .append("taskType=" + this.a + ",");
/* 171 */     buf.append("createDate=" + this.b + ",");
/* 172 */     buf.append("acceptDate=" + this.c + ",");
/* 173 */     buf.append("startDate=" + this.d + ",");
/* 174 */     buf.append("endDate=" + this.e + ",");
/* 175 */     buf.append("mailFrom=" + this.f + ",");
/* 176 */     buf.append("mailTo=" + this.g + ",");
/* 177 */     buf.append("mailSubject=" + this.h + ",");
/* 178 */     buf.append("mailBody=" + this.i + ",");
/* 179 */     buf.append("atts=" + ((this.j == null) || (this.j.length == 0) ? "" : this.j[0]) + ",");
/* 180 */     buf.append("attNames=" + ((this.k == null) || (this.k.length == 0) ? "" : this.k[0]) + ",");
/* 181 */     buf.append("result=" + this.l + ",");
/* 182 */     buf.append("message=" + this.m + "\r\n");
/*     */ 
/* 184 */     return buf.toString();
/*     */   }
/*     */ }

/* Location:           H:\New\monitor\monitor.jar
 * Qualified Name:     com.zyzhou.agent.b
 * JD-Core Version:    0.6.2
 */