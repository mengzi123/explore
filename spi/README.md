SPI：Service Provider Interface

 一个服务(Service)通常指的是已知的接口或者抽象类，服务提供方就是对这个接口或者抽象类的实现，然后按照SPI 标准存放到资源路径META-INF/services目录下，文件的命名为该服务接口的全限定名

 许多开发框架都使用了Java的SPI机制，如java.sql.Driver的SPI实现（mysql驱动、oracle驱动等）、common-logging的日志接口实现、dubbo的扩展实现等等。

 我们系统里抽象的各个模块，往往有很多不同的实现方案，比如日志模块的方案，xml解析模块、jdbc模块的方案等。面向的对象的设计里，我们一般推荐模块之间基于接口编程，模块之间不对实现类进行硬编码。一旦代码里涉及具体的实现类，就违反了可拔插的原则，如果需要替换一种实现，就需要修改代码。

 为了实现在模块装配的时候能不在程序里动态指明，这就需要一种服务发现机制。java spi就是提供这样的一个机制：为某个接口寻找服务实现的机制。有点类似IOC的思想，就是将装配的控制权移到程序之外，在模块化设计中这个机制尤其重要。

 java spi的具体约定如下：当服务的提供者，提供了服务接口的一种实现之后，在jar包的META-INF/services/目录里同时创建一个以服务接口命名的文件。该文件里就是实现该服务接口的具体实现类。而当外部程序装配这个模块的时候，就能通过该jar包META-INF/services/里的配置文件找到具体的实现类名，并装载实例化，完成模块的注入