package com.artemzin.autojacson;

import com.artemzin.autojackson.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class TweetTest {

  @Test
  public void shouldSerializeToJson() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    Tweet tweet = Tweet.builder()
      .author("@artem_zin")
      .content("Immutability for everybody!")
      .build();

    assertThat(objectMapper.writeValueAsString(tweet)).isEqualTo("{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\"}");
  }

  @Test
  public void shouldDeserializeFromJson() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    String json = "{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\"}";

    Tweet tweet = objectMapper.readValue(json, Tweet.class);

    assertThat(tweet.author()).isEqualTo("@artem_zin");
    assertThat(tweet.content()).isEqualTo("Immutability for everybody!");
  }
}
