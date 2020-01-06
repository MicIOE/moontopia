/*    */ package com.zyzhou.platform.manager;
/*    */ 
/*    */ import org.springframework.beans.BeansException;
/*    */ import org.springframework.context.ApplicationContext;
/*    */ import org.springframework.context.ApplicationContextAware;
/*    */ import org.springframework.context.support.ClassPathXmlApplicationContext;
/*    */ 
/*    */ public class ManagerFactory
/*    */   implements ApplicationContextAware
/*    */ {
/*    */   private static volatile ApplicationContext a;
/*    */ 
/*    */   public final void setApplicationContext(ApplicationContext context)
/*    */     throws BeansException
/*    */   {
/* 27 */     a = context;
/*    */   }
/*    */ 
/*    */   public static ApplicationContext getContext()
/*    */   {
/* 37 */     if (a == null) {
/* 38 */       synchronized (ManagerFactory.class) {
/* 39 */         if (a == null) {
/* 40 */           a = new ClassPathXmlApplicationContext(
/* 41 */             new String[] { "config/applicationContext.xml" });
/*    */         }
/*    */       }
/*    */     }
/* 45 */     return a;
/*    */   }
/*    */ 
/*    */   public static Object getBean(String name)
/*    */   {
/* 56 */     return getContext().getBean(name);
/*    */   }
/*    */ }

/* Location:           H:\New\monitor\monitor.jar
 * Qualified Name:     com.zyzhou.platform.manager.ManagerFactory
 * JD-Core Version:    0.6.2
 */