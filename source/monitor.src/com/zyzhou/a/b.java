/*     */ package com.zyzhou.a;
/*     */ 
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public final class b
/*     */ {
/*  27 */   private static final Logger a = Logger.getLogger(b.class);
/*     */ 
/*     */   public static String a(String path)
/*     */   {
/*  53 */     return a(path, false);
/*     */   }
/*     */ 
/*     */   // ERROR //
/*     */   private static String a(String path, boolean withEnter)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokestatic 19	com/zyzhou/a/a:a	(Ljava/lang/String;)Z
/*     */     //   4: ifeq +13 -> 17
/*     */     //   7: getstatic 18	com/zyzhou/a/b:a	Lorg/apache/log4j/Logger;
/*     */     //   10: ldc 6
/*     */     //   12: invokevirtual 37	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   15: aconst_null
/*     */     //   16: areturn
/*     */     //   17: new 15	java/lang/StringBuffer
/*     */     //   20: dup
/*     */     //   21: ldc 1
/*     */     //   23: invokespecial 29	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
/*     */     //   26: astore_1
/*     */     //   27: aconst_null
/*     */     //   28: astore_2
/*     */     //   29: new 10	java/io/File
/*     */     //   32: dup
/*     */     //   33: aload_0
/*     */     //   34: invokespecial 24	java/io/File:<init>	(Ljava/lang/String;)V
/*     */     //   37: invokevirtual 25	java/io/File:exists	()Z
/*     */     //   40: ifne +30 -> 70
/*     */     //   43: getstatic 18	com/zyzhou/a/b:a	Lorg/apache/log4j/Logger;
/*     */     //   46: new 16	java/lang/StringBuilder
/*     */     //   49: dup
/*     */     //   50: ldc 5
/*     */     //   52: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   55: aload_0
/*     */     //   56: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   59: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   62: invokevirtual 37	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   65: goto +3 -> 68
/*     */     //   68: aconst_null
/*     */     //   69: areturn
/*     */     //   70: new 9	java/io/BufferedReader
/*     */     //   73: dup
/*     */     //   74: new 13	java/io/InputStreamReader
/*     */     //   77: dup
/*     */     //   78: new 11	java/io/FileInputStream
/*     */     //   81: dup
/*     */     //   82: aload_0
/*     */     //   83: invokespecial 26	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
/*     */     //   86: ldc 2
/*     */     //   88: invokespecial 27	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
/*     */     //   91: invokespecial 21	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
/*     */     //   94: astore_2
/*     */     //   95: goto +11 -> 106
/*     */     //   98: aload_1
/*     */     //   99: aload_3
/*     */     //   100: invokevirtual 30	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
/*     */     //   103: pop
/*     */     //   104: aload_1
/*     */     //   105: pop
/*     */     //   106: aload_2
/*     */     //   107: invokevirtual 23	java/io/BufferedReader:readLine	()Ljava/lang/String;
/*     */     //   110: dup
/*     */     //   111: astore_3
/*     */     //   112: ifnonnull -14 -> 98
/*     */     //   115: goto +103 -> 218
/*     */     //   118: astore_3
/*     */     //   119: getstatic 18	com/zyzhou/a/b:a	Lorg/apache/log4j/Logger;
/*     */     //   122: new 16	java/lang/StringBuilder
/*     */     //   125: dup
/*     */     //   126: ldc 4
/*     */     //   128: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   131: aload_0
/*     */     //   132: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   135: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   138: aload_3
/*     */     //   139: invokevirtual 35	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   142: aload_2
/*     */     //   143: ifnull +106 -> 249
/*     */     //   146: aload_2
/*     */     //   147: invokevirtual 22	java/io/BufferedReader:close	()V
/*     */     //   150: goto +99 -> 249
/*     */     //   153: astore_2
/*     */     //   154: getstatic 18	com/zyzhou/a/b:a	Lorg/apache/log4j/Logger;
/*     */     //   157: new 16	java/lang/StringBuilder
/*     */     //   160: dup
/*     */     //   161: ldc 3
/*     */     //   163: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   166: aload_0
/*     */     //   167: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   170: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   173: aload_2
/*     */     //   174: invokevirtual 35	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   177: goto +72 -> 249
/*     */     //   180: astore_1
/*     */     //   181: aload_2
/*     */     //   182: ifnull +34 -> 216
/*     */     //   185: aload_2
/*     */     //   186: invokevirtual 22	java/io/BufferedReader:close	()V
/*     */     //   189: goto +27 -> 216
/*     */     //   192: astore_2
/*     */     //   193: getstatic 18	com/zyzhou/a/b:a	Lorg/apache/log4j/Logger;
/*     */     //   196: new 16	java/lang/StringBuilder
/*     */     //   199: dup
/*     */     //   200: ldc 3
/*     */     //   202: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   205: aload_0
/*     */     //   206: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   209: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   212: aload_2
/*     */     //   213: invokevirtual 35	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   216: aload_1
/*     */     //   217: athrow
/*     */     //   218: aload_2
/*     */     //   219: invokevirtual 22	java/io/BufferedReader:close	()V
/*     */     //   222: goto +27 -> 249
/*     */     //   225: astore_2
/*     */     //   226: getstatic 18	com/zyzhou/a/b:a	Lorg/apache/log4j/Logger;
/*     */     //   229: new 16	java/lang/StringBuilder
/*     */     //   232: dup
/*     */     //   233: ldc 3
/*     */     //   235: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   238: aload_0
/*     */     //   239: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   242: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   245: aload_2
/*     */     //   246: invokevirtual 35	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   249: aload_1
/*     */     //   250: invokevirtual 31	java/lang/StringBuffer:toString	()Ljava/lang/String;
/*     */     //   253: areturn
/*     */     //
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   29	65	118	java/io/IOException
/*     */     //   70	115	118	java/io/IOException
/*     */     //   142	150	153	java/io/IOException
/*     */     //   29	65	180	finally
/*     */     //   70	142	180	finally
/*     */     //   181	189	192	java/io/IOException
/*     */     //   218	222	225	java/io/IOException
/*     */   }
/*     */ }

/* Location:           H:\New\monitor\monitor.jar
 * Qualified Name:     com.zyzhou.a.b
 * JD-Core Version:    0.6.2
 */