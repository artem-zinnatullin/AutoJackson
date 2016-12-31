package com.artemzin.autojacson;

import com.artemzin.autojackson.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

public class TweetTest {

  @Test
  public void shouldSerializeToJson() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    Tweet tweet = Tweet.builder()
      .author("@artem_zin")
      .content("Immutability for everybody!")
      .build();

    assertThatJson(objectMapper.writeValueAsString(tweet))
      .isEqualTo("{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\",\"blocked\":false}");
  }

  @Test
  public void shouldSerializeToJsonExtraField() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    Tweet tweet = Tweet.builder()
            .author("@artem_zin")
            .content("Immutability for everybody!")
            .blocked(true)
            .build();

    assertThatJson(objectMapper.writeValueAsString(tweet))
            .isEqualTo("{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\",\"blocked\":true}");
  }

  @Test
  public void shouldSerializeToJsonExtraFieldFalse() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    Tweet tweet = Tweet.builder()
            .author("@artem_zin")
            .content("Immutability for everybody!")
            .blocked(false)
            .build();

    assertThatJson(objectMapper.writeValueAsString(tweet))
            .isEqualTo("{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\",\"blocked\":false}");
  }

  @Test
  public void shouldDeserializeFromJson() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    String json = "{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\"}";

    Tweet tweet = objectMapper.readValue(json, Tweet.class);

    assertThat(tweet.author()).isEqualTo("@artem_zin");
    assertThat(tweet.content()).isEqualTo("Immutability for everybody!");
    assertThat(tweet.blocked()).isFalse();
  }

  @Test
  public void shouldDeserializeFromJsonExtraField() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    String json = "{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\", \"blocked\":true}";

    Tweet tweet = objectMapper.readValue(json, Tweet.class);

    assertThat(tweet.author()).isEqualTo("@artem_zin");
    assertThat(tweet.content()).isEqualTo("Immutability for everybody!");
    assertThat(tweet.blocked()).isTrue();
  }

  @Test
  public void shouldDeserializeFromJsonExtraFieldFalse() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    String json = "{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\", \"blocked\":false}";

    Tweet tweet = objectMapper.readValue(json, Tweet.class);

    assertThat(tweet.author()).isEqualTo("@artem_zin");
    assertThat(tweet.content()).isEqualTo("Immutability for everybody!");
    assertThat(tweet.blocked()).isFalse();
  }
}
