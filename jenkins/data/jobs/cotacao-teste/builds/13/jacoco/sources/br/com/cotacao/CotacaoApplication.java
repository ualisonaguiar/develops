package br.com.cotacao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CotacaoApplication {

	@Value("${spring.application.name}")
	private String nmApp;

	@Value("${jaeger.url}")
	private String hostJaeger;

//	@Bean
//	public io.opentracing.Tracer jaegerTreacer() {
//		return new Configuration(nmApp,
//				new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1, hostJaeger.concat(":5778")),
//				new Configuration.ReporterConfiguration(false, hostJaeger, 6831, 1000, 100)).getTracer();
//	}

	public static void main(String[] args) {
		SpringApplication.run(CotacaoApplication.class, args);
	}

}
