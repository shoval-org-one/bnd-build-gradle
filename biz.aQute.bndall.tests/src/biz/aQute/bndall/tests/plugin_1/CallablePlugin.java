package biz.aQute.bndall.tests.plugin_1;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;

import aQute.bnd.service.Plugin;
import aQute.bnd.service.externalplugin.ExternalPlugin;
import aQute.service.reporter.Reporter;

@ExternalPlugin(name = "hellocallable", objectClass = Callable.class)
public class CallablePlugin implements Callable<String>, Closeable, Plugin {
	boolean closed;
	String	world	= "world";

	@Override
	public String call() throws Exception {
		if (closed)
			return "goodbye, " + world;
		else
			return "hello, " + world;
	}

	@Override
	public void close() throws IOException {
		System.out.println("closed");
		closed = true;
	}

	@Override
	public void setProperties(Map<String, String> map) throws Exception {
		world = map.get("world");
	}

	@Override
	public void setReporter(Reporter processor) {
		// ignore
	}

}
