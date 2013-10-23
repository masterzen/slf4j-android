package org.slf4j.impl;

public class RingBuffer
{
  private final CircularFifoQueue<String> ring;
  
  public RingBuffer(int maxLines)
  {
    ring = new CircularFifoQueue<String>();
  }
  
  public synchronized String store(String level, String name, String txt)
  {
    try {
      ring.add(level + " - " + name + ":" + txt);
    } catch(Throwable t) {}
    return txt;
  }
  
  public synchronized String getLogs()
  {
    StringBuilder b = new StringBuilder(64*1024);
    for(String log : ring) {
      b.append(log).append('\n');
    }
    return b.toString();
  }
}
