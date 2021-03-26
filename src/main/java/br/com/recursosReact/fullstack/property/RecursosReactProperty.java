package br.com.recursosReact.fullstack.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("recursosreact")
public class RecursosReactProperty {
	
	private String originPermitida = "http://localhost:3000";
	
	private final Seguranca seguranca = new Seguranca();
	
	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public static class Seguranca {
		
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		
	}

}
