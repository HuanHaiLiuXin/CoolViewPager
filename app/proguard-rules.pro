# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#不能混淆的项
#在AndroidManifest中配置的类，比如四大组件
#JNI调用的方法
#反射用到的类
#WebView中JavaScript调用的方法
#Layout文件引用到的自定义View
#一些引入的第三方库

#关键字                       描述
#keep                        保留类和类中的成员，防止被混淆或移除
#keepnames                   保留类和类中的成员，防止被混淆，成员没有被引用会被移除
#keepclassmembers            只保留类中的成员，防止被混淆或移除
#keepclassmembernames        只保留类中的成员，防止被混淆，成员没有引用会被移除
#keepclasseswithmembers      保留类和类中的成员，防止被混淆或移除，保留指明的成员
#keepclasseswithmembernames  保留类和类中的成员，防止被混淆，保留指明的成员，成员没有引用会被移除

#通配符       描述
#<fields>     匹配类中的所有字段
#<methods>    匹配类中所有的方法
#<init>      匹配类中所有的构造函数
#*           匹配任意长度字符，不包含包名分隔符(.)
#**          匹配任意长度字符，包含包名分隔符(.)
#***         匹配任意参数类型
#...         匹配任意长度的任意类型参数。比如void test(…)就能匹配任意void test(String a)或者是void test(int a, String b)这些方法。

# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/tb/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

#==================基本混淆======================================================
# Add any project specific keep options here:

#####################基本指令##############################################
# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute SourceFile
#代码混淆压缩比，在0～7之间，默认为5，一般不需要改
-optimizationpasses 5
#混淆时不使用大小写混合，混淆后的类名为小写
-dontusemixedcaseclassnames
#指定不去忽略非公共的库的类
-dontskipnonpubliclibraryclasses
#指定不去忽略非公共的库的类的成员
-dontskipnonpubliclibraryclassmembers
#不做预校验，preverify是proguard的4个步骤之一
#Android不需要preverify，去掉这一步可加快混淆速度
-dontpreverify
#有了verbose这句话，混淆后就会生成映射文件
#包含有类名->混淆后类名的映射关系
-verbose
#然后使用printmapping指定映射文件的名称
-printmapping mapping.txt
#指定混淆时采用的算法，后面的参数是一个过滤器，这个过滤器是谷歌推荐的算法，一般不改变
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#保护代码中的Annotation不被混淆，这在JSON实体映射时非常重要(保留注解参数)
-keepattributes *Annotation*
#避免混淆泛型，这在JSON实体映射时非常重要
-keepattributes Signature
#抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable

#忽略所有警告
-ignorewarnings

###################需要保留的东西########################################

#保留反射的方法和类不被混淆================================================
#手动启用support keep注解
#http://tools.android.com/tech-docs/support-annotations

-keep class android.support.annotation.Keep
-keep @android.support.annotation.Keep class * {*;}
-keepclasseswithmembers class * {
    @android.support.annotation.Keep <methods>;
}
-keepclasseswithmembers class * {
    @android.support.annotation.Keep <fields>;
}
-keepclasseswithmembers class * {
    @android.support.annotation.Keep <init>(...);
}

#==========================================================================================

#保留所有的本地native方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}
#保留了继承自Activity、Application这些类的子类
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Fragment
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class * extends com.android.vending.licensing.ILicensingService
-keep class android.support.** {*;}

#保留在Activity中的方法参数是view的方法，从而我们在layout里面便携onClick就不会受影响
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}
#枚举类不能被混淆
-keepclassmembers enum *{
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#保留自定义控件不被混淆
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    void set*(***);
    *** get*();
}
#保留Parcelable序列化的类不被混淆
-keep class * implements android.os.Paracelable{
    public static final android.os.Paracelable$Creator *;
}
#保留Serializable序列化的类的如下成员不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
#对于R（资源）下的所有类及其方法，都不能被混淆
-keep class **.R$*{
    *;
}
#R文件中的所有记录资源id的静态字段
-keepclassmembers class **.R$* {
    public static <fields>;
}
#对于带有回调函数onXXEvent的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
}

#============================针对app的量身定制=============================================

# webView处理，项目中没有使用到webView忽略即可
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, java.lang.String);
}