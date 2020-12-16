package fr.asuniia.breakgo.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
    static final SimpleDateFormat format;
    private static boolean isDebugEnabled;
    private final String prefix;
    
    static {
        format = new SimpleDateFormat("hh:mm:ss");
        Logger.isDebugEnabled = false;
    }
    
    public Logger(final String prefix) {
        this.prefix = prefix;
    }
    
    public static Logger getLogger(final String prefix) {
        return new Logger(prefix);
    }
    
    public static void setDebug(final boolean debug) {
        Logger.isDebugEnabled = debug;
    }
    
    public void info(final String msg) {
        System.out.println("(" + Logger.format.format(new Date()) + ") (Info)  (C) " + ((this.prefix == null) ? "> " : ("|" + this.prefix + "| > ")) + msg);
    }
    
    public void warn(final String msg) {
        System.out.println("(" + Logger.format.format(new Date()) + ") (Warn)  (C) " + ((this.prefix == null) ? "> " : ("|" + this.prefix + "| > ")) + msg);
    }
    
    public void error(final String msg) {
        System.out.println("(" + Logger.format.format(new Date()) + ") (Error) (C) " + ((this.prefix == null) ? "> " : ("|" + this.prefix + "| > ")) + msg);
    }
    
    public void fatal(final String msg) {
        System.out.println("(" + Logger.format.format(new Date()) + ") (FATAL) (C) " + ((this.prefix == null) ? "> " : ("|" + this.prefix + "| > ")) + msg);
    }
    
    public void debug(final String msg) {
        if (Logger.isDebugEnabled) {
            System.out.println("(" + Logger.format.format(new Date()) + ") (Debug) (C) " + ((this.prefix == null) ? "> " : ("|" + this.prefix + "| > ")) + msg);
        }
    }

}
