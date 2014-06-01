/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author bartek
 */
import java.io.Serializable;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Person_list implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ExecutorService executorService =
        Executors.newSingleThreadExecutor();

    public interface BroadcastListener {
        void receiveBroadcast(Person p);
    }
    
    private static LinkedList<BroadcastListener> listeners =
        new LinkedList<BroadcastListener>();
    
    public static synchronized void register(
            BroadcastListener listener) {
        listeners.add(listener);
    }
    
    public static synchronized void unregister(
            BroadcastListener listener) {
        listeners.remove(listener);
    }
    
    public static synchronized void broadcast(
            final Person p) {
        for (final BroadcastListener listener: listeners)
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    listener.receiveBroadcast(p);
                }
            });
    }
}
