package org.slf4j.impl;

import android.util.Log;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

public class AndroidLogger  extends MarkerIgnoringBase {
  
	private RingBuffer buffer;

  public AndroidLogger(String name, RingBuffer buffer) {
		this.name = name;
		this.buffer = buffer;
	}

	public boolean isTraceEnabled() {
		return Log.isLoggable(name, Log.VERBOSE);
	}

	public void trace(String msg) {
    buffer.store("trace", name, msg);
		Log.v(name, msg);
	}

	public void trace(String format, Object arg) {
		FormattingTuple ft = MessageFormatter.format(format, arg);
		trace(ft.getMessage());
	}

	public void trace(String format, Object arg1, Object arg2) {
		FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
		trace(ft.getMessage());
	}

	public void trace(String format, Object[] args) {
		FormattingTuple ft = MessageFormatter.format(format, args);
		trace(ft.getMessage());
	}

	public void trace(String msg, Throwable throwable) {
    buffer.store("trace", name, MessageFormatter.format(msg, throwable).getMessage());
		Log.v(name, msg, throwable);
	}

	public boolean isDebugEnabled() {
		return Log.isLoggable(name, Log.DEBUG);
	}

	public void debug(String msg) {
	  buffer.store("debug", name, msg);
		Log.d(name, msg);
	}

	public void debug(String format, Object arg) {
		FormattingTuple ft = MessageFormatter.format(format, arg);
		debug(ft.getMessage());
	}

	public void debug(String format, Object arg1, Object arg2) {
		FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
		debug(ft.getMessage());
	}

	public void debug(String format, Object[] args) {
		FormattingTuple ft = MessageFormatter.format(format, args);
		debug(ft.getMessage());
	}

	public void debug(String msg, Throwable throwable) {
    buffer.store("debug", name, MessageFormatter.format(msg, throwable).getMessage());
		Log.d(name, msg, throwable);
	}

	public boolean isInfoEnabled() {
		return Log.isLoggable(name, Log.INFO);
	}

	public void info(String msg) {
    buffer.store("info", name, msg);
		Log.i(name, msg);
	}

	public void info(String format, Object arg) {
		FormattingTuple ft = MessageFormatter.format(format, arg);
		info(ft.getMessage());
	}

	public void info(String format, Object arg1, Object arg2) {
		FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
		info(ft.getMessage());
	}

	public void info(String format, Object[] args) {
		FormattingTuple ft = MessageFormatter.format(format, args);
		info(ft.getMessage());
	}

	public void info(String msg, Throwable throwable) {
    buffer.store("debug", name, MessageFormatter.format(msg, throwable).getMessage());
		Log.i(name, msg, throwable);
	}

	public boolean isWarnEnabled() {
		return Log.isLoggable(name, Log.WARN);
	}

	public void warn(String msg) {
    buffer.store("warn", name, msg);
		Log.w(name, msg);
	}

	public void warn(String format, Object arg) {
		FormattingTuple ft = MessageFormatter.format(format, arg);
		warn(ft.getMessage());
	}

	public void warn(String format, Object[] args) {
		FormattingTuple ft = MessageFormatter.format(format, args);
		warn(ft.getMessage());
	}

	public void warn(String format, Object arg1, Object arg2) {
		FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
		warn(ft.getMessage());
	}

	public void warn(String msg, Throwable throwable) {
    buffer.store("warn", name, MessageFormatter.format(msg, throwable).getMessage());
		Log.w(name, msg, throwable);
	}

	public boolean isErrorEnabled() {
		return Log.isLoggable(name, Log.ERROR);
	}

	public void error(String msg) {
    buffer.store("error", name, msg);
		Log.e(name, msg);
	}

	public void error(String format, Object arg) {
		FormattingTuple ft = MessageFormatter.format(format, arg);
		error(ft.getMessage());
	}

	public void error(String format, Object arg1, Object arg2) {
		FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
		error(ft.getMessage());
	}

	public void error(String format, Object[] args) {
		FormattingTuple ft = MessageFormatter.format(format, args);
		error(ft.getMessage());
	}

	public void error(String msg, Throwable throwable) {
    buffer.store("error", name, MessageFormatter.format(msg, throwable).getMessage());
		Log.e(name, msg, throwable);
	}
}
