package org.nutz.ssdb4j.shard;

import java.net.URI;

import org.apache.commons.pool.impl.GenericObjectPool.Config;
import org.nutz.ssdb4j.SSDBs;
import org.nutz.ssdb4j.impl.SimpleClient;
import org.nutz.ssdb4j.pool.PoolSSDBStream;
import org.nutz.ssdb4j.pool.SocketSSDBStreamPool;

public class SSDBShardInfo extends ShardInfo<SimpleClient> {
	
	public String toString() {
		return host + ":" + port + "*" + getWeight();
	}

	private int timeout;
	private String host;
	private int port;
	private String name = null;
	private Config config = null;

	public SSDBShardInfo(String host) {
		super(Sharded.DEFAULT_WEIGHT);
		URI uri = URI.create(host);
		if (uri.getScheme() != null && uri.getScheme().equals("ssdb")) {
			this.host = uri.getHost();
			this.port = uri.getPort();
		} else {
			this.host = host;
			this.port = SSDBs.DEFAULT_PORT;
		}
	}

	public SSDBShardInfo(String host, String name) {
		this(host, SSDBs.DEFAULT_PORT, name);
	}

	public SSDBShardInfo(String host, int port) {
		this(host, port, SSDBs.DEFAULT_TIMEOUT);
	}

	public SSDBShardInfo(String host, int port, String name) {
		this(host, port, SSDBs.DEFAULT_TIMEOUT, name, null);
	}

	public SSDBShardInfo(String host, int port, int timeout) {
		this(host, port, timeout, Sharded.DEFAULT_WEIGHT, null);
	}

	public SSDBShardInfo(String host, int port, int timeout, String name, Config config) {
		this(host, port, timeout, Sharded.DEFAULT_WEIGHT, config);
		this.name = name;
	}

	public SSDBShardInfo(String host, int port, int timeout, int weight, Config config) {
		super(weight);
		this.host = host;
		this.port = port;
		this.timeout = timeout;
		this.config = config;
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
	
	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public Config getConfig() {
		return config;
	}

	@Override
	public SimpleClient createResource() {
		if (config == null) {
			return new SimpleClient(host, port, timeout);
		} else {
			return new SimpleClient(
					new PoolSSDBStream(
							new SocketSSDBStreamPool(host, port, timeout, config)));
		}
	}
}