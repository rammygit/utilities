package com.entitytest.util;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.core.config.Configuration;
import org.hornetq.core.config.impl.ConfigurationImpl;
import org.hornetq.core.remoting.impl.netty.NettyAcceptorFactory;
import org.hornetq.jms.server.config.JMSConfiguration;
import org.hornetq.jms.server.config.JMSQueueConfiguration;
import org.hornetq.jms.server.config.impl.JMSConfigurationImpl;
import org.hornetq.jms.server.config.impl.JMSQueueConfigurationImpl;
import org.hornetq.jms.server.embedded.EmbeddedJMS;




/**
 * 
 * @author ram
 *
 */
public class HornetQServer {

	//private HornetQServer server;

	private JMSConfiguration jmsConfig;
	private EmbeddedJMS jmsServer;

	public void start(){
		AppLogger.info(this.getClass(), "************ JMS server starting for unit testing ***************");
		Configuration configuration = new ConfigurationImpl();
		// configuration.setJournalDirectory("build/data/journal");
		configuration.setPersistenceEnabled(false);
		configuration.setSecurityEnabled(false);

		TransportConfiguration serverTransportConfiguration = new TransportConfiguration(NettyAcceptorFactory.class.getName());
		configuration.getAcceptorConfigurations().add(serverTransportConfiguration);
		jmsServer = new EmbeddedJMS();
		jmsServer.setConfiguration(configuration);
		jmsServer.setJmsConfiguration(jmsConfig());

		try {
			jmsServer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stop(){
		AppLogger.info(this.getClass(), "************ JMS server shutting down ***************");
		try {
			jmsServer.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AppLogger.info(this.getClass(), "************ JMS server stop encountered error. ***************");
			//e.printStackTrace();
		}
	}

	private JMSConfiguration jmsConfig(){
		// configure jms
		jmsConfig = new JMSConfigurationImpl();		
		// configure the JMS Queues
		JMSQueueConfiguration queueConfig = new JMSQueueConfigurationImpl("queue1", null, true);
		jmsConfig.getQueueConfigurations().add(queueConfig);
		
		JMSQueueConfiguration queueConfig2 = new JMSQueueConfigurationImpl("queue2", null, true);
		jmsConfig.getQueueConfigurations().add(queueConfig2);
		
		JMSQueueConfiguration queueConfig3 = new JMSQueueConfigurationImpl("queue3", null, true);
		jmsConfig.getQueueConfigurations().add(queueConfig3);
		
		JMSQueueConfiguration queueConfig4 = new JMSQueueConfigurationImpl("queue4", null, true);
		jmsConfig.getQueueConfigurations().add(queueConfig4);
		
		JMSQueueConfiguration queueConfig5 = new JMSQueueConfigurationImpl("queue5", null, true);
		jmsConfig.getQueueConfigurations().add(queueConfig5);
		
		JMSQueueConfiguration queueConfig6 = new JMSQueueConfigurationImpl("queue6", null, true);
		jmsConfig.getQueueConfigurations().add(queueConfig6);
		
		return jmsConfig;
	}


}
