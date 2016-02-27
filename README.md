# utilities

About utilities I have developed. 

HornetQServer.java 
pom.xml

<properties>
<hornetq-jms-client.version>2.4.7.Final</hornetq-jms-client.version>
		<hornetq.core.client.version>2.4.7.Final</hornetq.core.client.version>
		<hornetq.jms.server.version>2.4.7.Final</hornetq.jms.server.version>
		<org.jboss.netty.version>3.2.3.Final</org.jboss.netty.version>
		<hornetq.core.version>2.2.21.Final</hornetq.core.version>
		</properties>

			<!-- HornetQ dependency are specified at Test scope in parent -->

			<dependency>
				<groupId>org.hornetq</groupId>
				<artifactId>hornetq-jms-client</artifactId>
				<version>${hornetq-jms-client.version}</version>
				<scope>test</scope>
			</dependency>

			<dependency>
				<groupId>org.hornetq</groupId>
				<artifactId>hornetq-core-client</artifactId>
				<version>${hornetq.core.client.version}</version>
				<scope>test</scope>
			</dependency>

			<dependency>
				<groupId>org.hornetq</groupId>
				<artifactId>hornetq-jms-server</artifactId>
				<version>${hornetq.jms.server.version}</version>
				<exclusions>
					<exclusion>
						<groupId>org.jboss.naming</groupId>
						<artifactId>jnpserver</artifactId>
					</exclusion>
				</exclusions>
				<scope>test</scope>
			</dependency>

			<dependency>
				<groupId>org.jboss.netty</groupId>
				<artifactId>netty</artifactId>
				<version>${org.jboss.netty.version}</version>
				<scope>test</scope>
			</dependency>

			<dependency>
				<groupId>org.hornetq</groupId>
				<artifactId>hornetq-core</artifactId>
				<version>${hornetq.core.version}</version>
				<scope>test</scope>
			</dependency>


			<!-- end of HornetQ dependencies -->
