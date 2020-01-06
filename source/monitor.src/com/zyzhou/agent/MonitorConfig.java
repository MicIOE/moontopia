/*     */ package com.zyzhou.agent;
/*     */ 
/*     */ import com.thoughtworks.xstream.annotations.XStreamAlias;
/*     */ 
/*     */ @XStreamAlias("MonitorConfig")
/*     */ public class MonitorConfig
/*     */   implements Cloneable
/*     */ {
/*     */ 
/*     */   @XStreamAlias("mailSmtpHost")
/*     */   private String mailSmtpHost;
/*     */ 
/*     */   @XStreamAlias("mailTransportProtocol")
/*     */   private String mailTransportProtocol;
/*     */ 
/*     */   @XStreamAlias("mailSmtpPort")
/*     */   private int mailSmtpPort;
/*     */ 
/*     */   @XStreamAlias("mailSmtpAuth")
/*     */   private String mailSmtpAuth;
/*     */ 
/*     */   @XStreamAlias("mailDebug")
/*     */   private String mailDebug;
/*     */ 
/*     */   @XStreamAlias("mailStoreHost")
/*     */   private String mailStoreHost;
/*     */ 
/*     */   @XStreamAlias("mailStoreProtocol")
/*     */   private String mailStoreProtocol;
/*     */ 
/*     */   @XStreamAlias("mailStorePort")
/*     */   private int mailStorePort;
/*     */ 
/*     */   @XStreamAlias("mailUser")
/*     */   private String mailUser;
/*     */ 
/*     */   @XStreamAlias("mailPassword")
/*     */   private String mailPassword;
/*     */ 
/*     */   @XStreamAlias("soTimeout")
/*     */   private int soTimeout;
/*     */ 
/*     */   @XStreamAlias("connectionTimeout")
/*     */   private int connectionTimeout;
/*     */ 
/*     */   @XStreamAlias("deviceId")
/*     */   private String deviceId;
/*     */ 
/*     */   @XStreamAlias("signature")
/*     */   private String signature;
/*     */ 
/*     */   @XStreamAlias("deviceMailAddr")
/*     */   private String deviceMailAddr;
/*     */ 
/*     */   @XStreamAlias("masterMailAddr")
/*     */   private String masterMailAddr;
/*     */ 
/*     */   @XStreamAlias("photoPath")
/*     */   private String photoPath;
/*     */ 
/*     */   @XStreamAlias("temperatureCmd")
/*     */   private String temperatureCmd;
/*     */ 
/*     */   @XStreamAlias("photoCmd")
/*     */   private String photoCmd;
/*     */ 
/*     */   @XStreamAlias("lightOnCmd")
/*     */   private String lightOnCmd;
/*     */ 
/*     */   @XStreamAlias("lightOffCmd")
/*     */   private String lightOffCmd;
/*     */ 
/*     */   public String getLightOnCmd()
/*     */   {
/* 171 */     return this.lightOnCmd;
/*     */   }
/*     */ 
/*     */   public String getLightOffCmd()
/*     */   {
/* 179 */     return this.lightOffCmd;
/*     */   }
/*     */ 
/*     */   public String getTemperatureCmd()
/*     */   {
/* 187 */     return this.temperatureCmd;
/*     */   }
/*     */ 
/*     */   public String getPhotoCmd()
/*     */   {
/* 195 */     return this.photoCmd;
/*     */   }
/*     */ 
/*     */   public String getPhotoPath()
/*     */   {
/* 203 */     return this.photoPath;
/*     */   }
/*     */ 
/*     */   public String getDeviceMailAddr()
/*     */   {
/* 211 */     return this.deviceMailAddr;
/*     */   }
/*     */ 
/*     */   public String getMasterMailAddr()
/*     */   {
/* 219 */     return this.masterMailAddr;
/*     */   }
/*     */ 
/*     */   public String getMailSmtpHost()
/*     */   {
/* 227 */     return this.mailSmtpHost;
/*     */   }
/*     */ 
/*     */   public String getMailTransportProtocol()
/*     */   {
/* 235 */     return this.mailTransportProtocol;
/*     */   }
/*     */ 
/*     */   public int getMailSmtpPort()
/*     */   {
/* 243 */     return this.mailSmtpPort;
/*     */   }
/*     */ 
/*     */   public String getMailSmtpAuth()
/*     */   {
/* 251 */     return this.mailSmtpAuth;
/*     */   }
/*     */ 
/*     */   public String getMailDebug()
/*     */   {
/* 259 */     return this.mailDebug;
/*     */   }
/*     */ 
/*     */   public String getMailStoreHost()
/*     */   {
/* 267 */     return this.mailStoreHost;
/*     */   }
/*     */ 
/*     */   public String getMailStoreProtocol()
/*     */   {
/* 275 */     return this.mailStoreProtocol;
/*     */   }
/*     */ 
/*     */   public int getMailStorePort()
/*     */   {
/* 283 */     return this.mailStorePort;
/*     */   }
/*     */ 
/*     */   public String getMailUser()
/*     */   {
/* 291 */     return this.mailUser;
/*     */   }
/*     */ 
/*     */   public String getMailPassword()
/*     */   {
/* 299 */     return this.mailPassword;
/*     */   }
/*     */ 
/*     */   public int getSoTimeout()
/*     */   {
/* 307 */     return this.soTimeout;
/*     */   }
/*     */ 
/*     */   public int getConnectionTimeout()
/*     */   {
/* 315 */     return this.connectionTimeout;
/*     */   }
/*     */ 
/*     */   public String getDeviceId()
/*     */   {
/* 323 */     return this.deviceId;
/*     */   }
/*     */ 
/*     */   public String getSignature()
/*     */   {
/* 331 */     return this.signature;
/*     */   }
/*     */ 
/*     */   protected Object clone()
/*     */     throws CloneNotSupportedException
/*     */   {
/* 340 */     return super.clone();
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*     */     StringBuffer buf;
/* 346 */     (
/* 347 */       buf = new StringBuffer())
/* 347 */       .append("mailSmtpHost=" + this.mailSmtpHost + ",");
/* 348 */     buf.append("mailTransportProtocol=" + this.mailTransportProtocol + ",");
/* 349 */     buf.append("mailSmtpPort=" + this.mailSmtpPort + ",");
/* 350 */     buf.append("mailSmtpAuth=" + this.mailSmtpAuth + ",");
/* 351 */     buf.append("mailDebug=" + this.mailDebug + ",");
/* 352 */     buf.append("mailStoreHost=" + this.mailStoreHost + ",");
/* 353 */     buf.append("mailStoreProtocol=" + this.mailStoreProtocol + ",");
/* 354 */     buf.append("mailStorePort=" + this.mailStorePort + ",");
/* 355 */     buf.append("soTimeout=" + this.soTimeout + ",");
/* 356 */     buf.append("connectionTimeout=" + this.connectionTimeout + ",");
/* 357 */     buf.append("mailUser=" + this.mailUser + ",");
/* 358 */     buf.append("mailPassword=" + this.mailPassword + ",");
/* 359 */     buf.append("deviceMailAddr=" + this.deviceMailAddr + ",");
/* 360 */     buf.append("deviceId=" + this.deviceId + ",");
/* 361 */     buf.append("masterMailAddr=" + this.masterMailAddr + ",");
/* 362 */     buf.append("signature=" + this.signature + ",");
/* 363 */     buf.append("photoPath=" + this.photoPath + ",");
/* 364 */     buf.append("temperatureCmd=" + this.temperatureCmd + ",");
/* 365 */     buf.append("photoCmd=" + this.photoCmd + ",");
/* 366 */     buf.append("lightOnCmd=" + this.lightOnCmd + ",");
/* 367 */     buf.append("lightOffCmd=" + this.lightOffCmd + "\r\n");
/*     */ 
/* 370 */     return buf.toString();
/*     */   }
/*     */ }

/* Location:           H:\New\monitor\monitor.jar
 * Qualified Name:     com.zyzhou.agent.MonitorConfig
 * JD-Core Version:    0.6.2
 */