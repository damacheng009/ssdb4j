package org.nutz.ssdb4j.shard;

import java.net.URI;

import org.nutz.ssdb4j.impl.SimpleClient;

public class SSDBShardInfo extends ShardInfo<SimpleClient> {
	
	public String toString() {
		return host + ":" + port + "*" + getWeight();
	}

	private int timeout;
	private String host;
	private int port;
	private String name = null;

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public SSDBShardInfo(String host) {
		super(Sharded.DEFAULT_WEIGHT);
		URI uri = URI.create(host);
		if (uri.getScheme() != null && uri.getScheme().equals("ssdb")) {
			this.host = uri.getHost();
			this.port = uri.getPort();
		} else {
			this.host = host;
			this.port = 8888;
		}
	}

	public SSDBShardInfo(String host, String name) {
		this(host, 8888, name);
	}

	public SSDBShardInfo(String host, int port) {
		this(host, port, 2000);
	}

	public SSDBShardInfo(String host, int port, String name) {
		this(host, port, 2000, name);
	}

	public SSDBShardInfo(String host, int port, int timeout) {
		this(host, port, timeout, Sharded.DEFAULT_WEIGHT);
	}

	public SSDBShardInfo(String host, int port, int timeout, String name) {
		this(host, port, timeout, Sharded.DEFAULT_WEIGHT);
		this.name = name;
	}

	public SSDBShardInfo(String host, int port, int timeout, int weight) {
		super(weight);
		this.host = host;
		this.port = port;
		this.timeout = timeout;
	}

	public SSDBShardInfo(URI uri) {
		super(Sharded.DEFAULT_WEIGHT);
		this.host = uri.getHost();
		this.port = uri.getPort();
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getName() {
		return name;
	}

	@Override
	public SimpleClient createResource() {
		return new SimpleClient(host, port, timeout);
	}
}