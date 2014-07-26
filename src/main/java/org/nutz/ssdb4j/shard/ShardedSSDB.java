package org.nutz.ssdb4j.shard;

import java.util.List;
import java.util.regex.Pattern;

import org.nutz.ssdb4j.impl.SimpleClient;
import org.nutz.ssdb4j.spi.Response;

public class ShardedSSDB extends Sharded<SimpleClient, SSDBShardInfo> implements ShardedSSDBCmd {

	public ShardedSSDB(List<SSDBShardInfo> shards) {
		super(shards);
	}
	
	public ShardedSSDB(List<SSDBShardInfo> shards, Hashing algo) {
		super(shards, algo);
	}

	public ShardedSSDB(List<SSDBShardInfo> shards, Pattern tagPattern) {
		super(shards, Hashing.MURMUR_HASH, tagPattern); // MD5 is really not good
	}

	public ShardedSSDB(List<SSDBShardInfo> shards, Hashing algo, Pattern tagPattern) {
		super(shards, algo, tagPattern);
	}
	
	//----------------------------------------------------------------------------------
	@Override
	public Response get(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.get(key);
	}

	@Override
	public Response set(Object key, Object val) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.set(key, val);
	}

	@Override
	public Response setx(Object key, Object val, int ttl) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.setx(key, val, ttl);
	}

	@Override
	public Response del(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.del(key);
	}

	@Override
	public Response incr(Object key, int val) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.incr(key, val);
	}

	@Override
	public Response exists(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.exists(key);
	}

	@Override
	public Response hset(Object key, Object hkey, Object hval) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hset(key, hkey, hval);
	}

	@Override
	public Response hdel(Object key, Object hkey) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hdel(key, hkey);
	}

	@Override
	public Response hget(Object key, Object hkey) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hget(key, hkey);
	}

	@Override
	public Response hsize(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hsize(key);
	}

	@Override
	public Response hlist(Object key, Object hkey, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hlist(key, hkey, limit);
	}

	@Override
	public Response hincr(Object key, Object hkey, int val) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hincr(key, hkey, val);
	}

	@Override
	public Response hscan(Object key, Object start, Object end, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hscan(key, start, end, limit);
	}

	@Override
	public Response hrscan(Object key, Object start, Object end, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hrscan(key, start, end, limit);
	}

	public Response zset(Object key, Object zkey, long score) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zset(key, zkey, score);
	}

	@Override
	public Response zget(Object key, Object zkey) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zget(key, zkey);
	}

	@Override
	public Response zdel(Object key, Object zkey) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zdel(key, zkey);
	}

	@Override
	public Response zincr(Object key, Object zkey, int val) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zincr(key, zkey, val);
	}

	@Override
	public Response zsize(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zsize(key);
	}
	
	@Override
	public Response zrank(Object key, Object zkey) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zrank(key, zkey);
	}

	@Override
	public Response zrrank(Object key, Object zkey) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zrrank(key, zkey);
	}

	@Override
	public Response zscan(Object key, Object zkey_start, long score_start, long score_end, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zscan(key, zkey_start, score_start, score_end, limit);
	}

	@Override
	public Response zrscan(Object key, Object zkey_start, long score_start, long score_end, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zrscan(key, zkey_start, score_start, score_end, limit);
	}

	@Override
	public Response qsize(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qsize(key);
	}

	@Override
	public Response qfront(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qfront(key);
	}

	@Override
	public Response qback(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qback(key);
	}

	@Override
	public Response qpush(Object key, Object value) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qpush(key, value);
	}

	@Override
	public Response qpop(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qpop(key);
	}

	@Override
	public Response qclear(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qclear(key);
	}

	@Override
	public Response hkeys(Object key, Object start, Object end, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hkeys(key, start, end, limit);
	}

	@Override
	public Response hexists(Object key, Object hkey) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hexists(key, hkey);
	}

	@Override
	public Response hclear(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hclear(key);
	}

	@Override
	public Response multi_hget(Object key, Object... hkeys) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.multi_hget(key, hkeys);
	}

	@Override
	public Response multi_hset(Object key, Object... pairs) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.multi_hset(key, pairs);
	}

	@Override
	public Response multi_hdel(Object key, Object... hkeys) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.multi_hdel(key, hkeys);
	}

	@Override
	public Response zexists(Object key, Object zkey) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zexists(key, zkey);
	}

	@Override
	public Response zclear(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zclear(key);
	}

	@Override
	public Response zkeys(Object key, Object zkey_start, long score_start, long score_end, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zkeys(key, zkey_start, score_start, score_end, limit);
	}

	@Override
	public Response zrange(Object key, int offset, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zrange(key, offset, limit);
	}

	@Override
	public Response zrrange(Object key, int offset, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zrrange(key, offset, limit);
	}

	@Override
	public Response multi_zset(Object key, Object... pairs) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.multi_zset(key, pairs);
	}

	@Override
	public Response multi_zget(Object key, Object... zkeys) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.multi_zget(key, zkeys);
	}

	@Override
	public Response multi_zdel(Object key, Object... zkeys) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.multi_zdel(key, zkeys);
	}
	
	//------------------------------------------

	@Override
	public Response setnx(Object key, Object val) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.setnx(key, val);
	}

	@Override
	public Response getset(Object key, Object val) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.getset(key, val);
	}

	@Override
	public Response qslice(Object key, int start, int end) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qslice(key, start, end);
	}

	@Override
	public Response qget(Object key, int index) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qget(key, index);
	}

	@Override
	public Response zcount(Object key, int start, int end) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zcount(key, start, end);
	}

	@Override
	public Response zsum(Object key, int start, int end) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zsum(key, start, end);
	}

	@Override
	public Response zavg(Object key, int start, int end) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zavg(key, start, end);
	}
	
	@Override
	public Response ttl(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.ttl(key);
	}
	
	@Override
	public Response decr(Object key, int val) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.decr(key, val);
	}
	
	@Override
	public Response hdecr(Object key, Object hkey, int val) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hdecr(key, hkey, val);
	}
	
	@Override
	public Response hgetall(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hgetall(key);
	}
	
	@Override
	public Response hvals(Object key, Object start, Object end, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.hvals(key, start, end, limit);
	}
	
	@Override
	public Response zdecr(Object key, Object zkey, int val) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zdecr(key, zkey, val);
	}
	
	@Override
	public Response zremrangebyrank(Object key, Object zkey_start, long score_start, long score_end, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zremrangebyrank(key, zkey_start, score_start, score_end, limit);
	}
	
	@Override
	public Response zremrangebyscore(Object key, Object zkey_start, long score_start, long score_end, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.zremrangebyscore(key, zkey_start, score_start, score_end, limit);
	}
	
	@Override
	public Response multi_zexists(Object key, Object... zkeys) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.multi_zexists(key, zkeys);
	}
	
	@Override
	public Response qpush_back(Object key, Object value) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qpush_back(key, value);
	}
	
	@Override
	public Response qpush_front(Object key, Object value) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qpush_front(key, value);
	}
	
	@Override
	public Response qpop_back(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qpop_back(key);
	}
	
	@Override
	public Response qpop_front(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qpop_front(key);
	}
	
	@Override
	public Response qrange(Object key, int begin, int limit) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qrange(key, begin, limit);
	}
	
	@Override
	public Response qfix(Object key) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.qfix(key);
	}
	
	@Override
	public Response expire(Object key, int ttl) {
		SimpleClient sc = getShardByKeyType(key);
		return sc.expire(key, ttl);
	}

	private SimpleClient getShardByKeyType(Object key) {
		SimpleClient sc = null;
		if (key instanceof String) {
			sc = getShard((String) key);
		} else if (key instanceof byte[]) {
			sc = getShard((byte[]) key);
		} else {
			// never
		}
		return sc;
	}

	public void disconnect() {
		for (SimpleClient sc : getAllShards()) {
			sc.close();
		}
	}
}
