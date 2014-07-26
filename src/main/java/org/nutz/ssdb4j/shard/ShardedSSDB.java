package org.nutz.ssdb4j.shard;

import org.nutz.ssdb4j.spi.Response;

public interface ShardedSSDB {

	public Response get(Object key);

	public Response set(Object key, Object val);

	public Response setx(Object key, Object val, int ttl);

	public Response del(Object key);

	public Response incr(Object key, int val);

	public Response exists(Object key);

	public Response hset(Object key, Object hkey, Object hval);

	public Response hdel(Object key, Object hkey);

	public Response hget(Object key, Object hkey);

	public Response hsize(Object key);

	public Response hlist(Object key, Object hkey, int limit);

	public Response hincr(Object key, Object hkey, int val);

	public Response hscan(Object key, Object start, Object end, int limit);

	public Response hrscan(Object key, Object start, Object end, int limit);

	public Response zset(Object key, Object zkey, long score);

	public Response zget(Object key, Object zkey);

	public Response zdel(Object key, Object zkey);

	public Response zincr(Object key, Object zkey, int val);

	public Response zsize(Object key);
	
	public Response zrank(Object key, Object zkey);

	public Response zrrank(Object key, Object zkey);

	public Response zscan(Object key, Object zkey_start, long score_start, long score_end, int limit);

	public Response zrscan(Object key, Object zkey_start, long score_start, long score_end, int limit);

	public Response qsize(Object key);

	public Response qfront(Object key);

	public Response qback(Object key);

	public Response qpush(Object key, Object value);

	public Response qpop(Object key);

	public Response qclear(Object key);

	public Response hkeys(Object key, Object start, Object end, int limit);

	public Response hexists(Object key, Object hkey);

	public Response hclear(Object key);

	public Response multi_hget(Object key, Object... hkeys);

	public Response multi_hset(Object key, Object... pairs);

	public Response multi_hdel(Object key, Object... hkeys);

	public Response zexists(Object key, Object zkey);

	public Response zclear(Object key);

	public Response zkeys(Object key, Object zkey_start, long score_start, long score_end, int limit);
	
	public Response zrange(Object key, int offset, int limit);

	public Response zrrange(Object key, int offset, int limit);

	public Response multi_zset(Object key, Object... pairs);

	public Response multi_zget(Object key, Object... zkeys);

	public Response multi_zdel(Object key, Object... zkeys);
	
	public Response setnx(Object key, Object val);

	public Response getset(Object key, Object val);

	public Response qslice(Object key, int start, int end);

	public Response qget(Object key, int index);

	public Response zcount(Object key, int start, int end);

	public Response zsum(Object key, int start, int end);

	public Response zavg(Object key, int start, int end);

	public Response ttl(Object key);
	
	public Response decr(Object key, int val);
	
	public Response hdecr(Object key, Object hkey, int val);
	
	public Response hgetall(Object key);

	public Response hvals(Object key, Object start, Object end, int limit);
	
	public Response zdecr(Object key, Object zkey, int val);
	
	public Response zremrangebyrank(Object key, Object zkey_start, long score_start, long score_end, int limit);
	
	public Response zremrangebyscore(Object key, Object zkey_start, long score_start, long score_end, int limit);
	
	public Response multi_zexists(Object key, Object... zkeys);

	public Response qpush_back(Object key, Object value);
	
	public Response qpush_front(Object key, Object value);
	
	public Response qpop_back(Object key);
	
	public Response qpop_front(Object key);
	
	public Response qrange(Object key, int begin, int limit);
	
	public Response qfix(Object key);
	
	public Response expire(Object key, int ttl);

}
