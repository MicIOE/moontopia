/*    */ package com.zyzhou.agent.entry;
/*    */ 
/*    */ import com.zyzhou.platform.manager.ManagerFactory;
/*    */ import org.quartz.Scheduler;
/*    */ import org.quartz.SchedulerException;
/*    */ 
/*    */ public class StartMonitor
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 30 */       (
/* 32 */         args = (Scheduler)ManagerFactory.getBean("schedulerFactory"))
/* 32 */         .start();
/* 33 */       return; } catch (SchedulerException localSchedulerException) { (
/* 34 */         args = localSchedulerException)
/* 34 */         .printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           H:\New\monitor\monitor.jar
 * Qualified Name:     com.zyzhou.agent.entry.StartMonitor
 * JD-Core Version:    0.6.2
 */