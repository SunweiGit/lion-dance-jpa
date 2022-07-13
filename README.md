# Getting Started

# jpa 支持的关键字
    详见 PartTree
	private static final String QUERY_PATTERN = "find|read|get|query|search|stream";
	private static final String COUNT_PATTERN = "count";
	private static final String EXISTS_PATTERN = "exists";
	private static final String DELETE_PATTERN = "delete|remove";


问题描述：
No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call
解决方法：
在对应的@Service或接口上添加@Transactional即可。

问题描述：
You're trying to execute a streaming query method without a surrounding transaction that keeps the connection open so that the Stream can actually be consumed. Make sure the code consuming the stream uses @Transactional or any other way of declaring a (read-only) transaction.
解决方法：
A Stream potentially wraps underlying data store specific resources and must therefore be closed after usage. You can either manually close the Stream using the close() method or by using a Java 7 try-with-resources block.

@ApiOperation(value = "streamByNameEquals")
@GetMapping(value = "streamByNameEquals")
@Transactional(readOnly = true)
public ResponseEntity<Optional<User>> streamByNameEquals(@RequestParam String name) {
try (Stream<User> stream = userRepository.streamByNameEquals(name)) {
return ResponseEntity.ok(stream.findFirst());
} }
