ssdb4j
======

又一个SSDB的Java驱动. 连接池,主从,都有了

SSDB官网
-----------------

https://github.com/ideawu/ssdb

License
-------------------
BSD 3-Clause License

maven
-----------------

```
<dependency>
    <groupId>org.nutz</groupId>
    <artifactId>ssdb4j</artifactId>
    <version>8.6</version>
</dependency>
```

依赖的jar
----------------

Apache Common Pool 1.6 http://commons.apache.org/proper/commons-pool/download_pool.cgi

最简单用法
----------------

```
import org.nutz.ssdb4j.spi.SSDB;
import org.nutz.ssdb4j.spi.Response;
import org.nutz.ssdb4j.SSDBs;


SSDB ssdb = SSDBs.simple();
ssdb.set("name", "wendal").check(); // call check() to make sure resp is ok 

Response resp = ssdb.get("name");
if (!resp.ok()) {
    // ...
} else {
    log.info("name=" + resp.asString());
}
```

模仿jedis，提供sharding
sharding只支持single key的命令，其他multi key等命令不支持
----------------

```
private static ShardedSSDBClient shardClient;

public static void main(String[] args) {
	
	Config config = new Config();
	config.maxActive = 30;
	config.maxIdle = 10;
	config.maxWait = 1000 * 5;
	config.minEvictableIdleTimeMillis = 1000 * 60;
	config.minIdle = 10;
	config.testOnBorrow = true;
	
	List<SSDBShardInfo> shards = 
			Arrays.asList(new SSDBShardInfo("localhost", 8888, 2000, "host1", config),
			new SSDBShardInfo("localhost", 8889, 2000, "host2", config));
	
	shardClient = sharded(shards);
	
	for (int i = 0; i < 1000; ++i) {
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				Random r = new Random();
				for (int i = 0; i < 1000; ++i) {
					shardClient.set("key" + r.nextInt(), "value" + r.nextInt());
				}
				
			}});
		thread.start();
	}
}
```