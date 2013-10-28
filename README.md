== SLF4J Android ==

SLF4J implementation for the Android Logcat facility, forked from nicstrong/slf4j-android.

=== Usage ===

In your jars and apklibs add the following dependency:

```
  <dependency>
     <groupId>org.slf4j</groupId>
     <artifactId>slf4j-api</artifactId>
     <version>1.6.1</version>
  </dependency>
```

Then in the Android app using the jars/apklibs that use slf4j add:

```
  <dependency>
     <groupId>com.daysofwonder.util</groupId>
     <artifactId>slf4j-android-dow</artifactId>
     <version>1.0.2</version>
  </dependency>
```  
  
=== What makes it so different ===  
  
The main difference between this version and any other slf4j-android version (including the upstream) is 
that it keeps in a circular buffer the all logged messages before handing them to LogCat.

So that if you use a crash reporter like HockeyApp, you can hand over the last log messages
along with the report, like this:

```java

		// This will fetch the last log entries before the crash
		// hopefully this will help us understand the issue
		CrashManagerListener listener = new CrashManagerListener() {
			@Override
			public String getDescription()
			{
				StaticLoggerBinder binder = StaticLoggerBinder.getSingleton();
				if (binder instanceof LogBufferable) {
					return binder.getBuffer();
				} else {
					return super.getDescription();
				}
			}
		};

		CrashManager.register(this, HOCKEY_APP_ID, listener);

```

Do not forget to remove logging from your release build with this Proguard snippet:

```
# We remove the trace level since it has nothing
# to do in production, but we keep debug and info
# as this is caught by slf4j-android-dow and stored for crash reporting
-assumenosideeffects class org.slf4j.Logger {
    public void trace(...);
}

# Let's remove the underlying log for release builds, except error and warning
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
}

```


