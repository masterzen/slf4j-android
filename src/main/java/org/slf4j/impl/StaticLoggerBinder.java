package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * The binding of {@link LoggerFactory} class with an actual instance of
 * {@link ILoggerFactory} is performed using information returned by this class.
 *
 * @author Nic Strong
 */
public class StaticLoggerBinder implements LoggerFactoryBinder, LogBufferable {

  /**
   * The unique instance of this class.
   *
   */
  private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

  /**
   * Return the singleton of this class.
   *
   * @return the StaticLoggerBinder singleton
   */
  public static final StaticLoggerBinder getSingleton() {
    return SINGLETON;
  }


  /**
   * Declare the version of the SLF4J API this implementation is compiled against.
   * The value of this field is usually modified with each release.
   */
  // to avoid constant folding by the compiler, this field must *not* be final
  public static String REQUESTED_API_VERSION = "1.6";  // !final


  private static final String loggerFactoryClassStr = AndroidLoggerFactory.class.getName();

  /** The ILoggerFactory instance returned by the {@link #getLoggerFactory} method
   * should always be the same object
   */
  private final ILoggerFactory loggerFactory;

  private final RingBuffer buffer = new RingBuffer(64 * 1024);
  
  private StaticLoggerBinder() {
//  Note: JCL gets substituted at build time by an appropriate Ant task
    loggerFactory = new AndroidLoggerFactory(buffer);
  }

  public ILoggerFactory getLoggerFactory() {
    return loggerFactory;
  }

  public String getLoggerFactoryClassStr() {
    return loggerFactoryClassStr;
  }
  
  public String getBuffer()
  {
    return buffer.getLogs();
  }
}
