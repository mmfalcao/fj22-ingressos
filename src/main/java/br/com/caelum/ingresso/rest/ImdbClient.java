package br.com.caelum.ingresso.rest;

import java.util.Optional;
// import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import org.apache.log4j.Logger;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

@Component
public class ImdbClient {
	private Logger logger = Logger.getLogger(ImdbClient.class);
	
	public <T>Optional<T> request(Filme filme, Class<T> tClass) {
		RestTemplate client = new RestTemplate();
		String titulo = filme.getNome().replace(" ", "+");
		String url = String.format("https://imdb-fj22.herokuapp.com/imdb?title=%s", titulo);
		
		try{
			//DetalhesDoFilme detalheDoFilme = client.getForObject(url, DetalhesDoFilme.class);
			return Optional.of(client.getForObject(url, tClass));
		} catch (RestClientException e) {
			logger.error(e.getMessage(), e);
			return Optional.empty();
		}
	}
}
