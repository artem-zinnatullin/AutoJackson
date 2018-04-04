package com.artemzin.autojacson;

import com.artemzin.autojackson.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

public class TweetTest {

  @Test
  public void shouldSerializeToJson() throws JsonProcessingException {
    ObjectMapper objectMapper = getObjectMapper();

    Tweet tweet = Tweet.builder()
      .author("@artem_zin")
      .content("Immutability for everybody!")
      .build();

    assertThatJson(objectMapper.writeValueAsString(tweet))
      .isEqualTo("{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\"}");
  }

  @Test
  public void shouldDeserializeFromJson() throws IOException {
    ObjectMapper objectMapper = getObjectMapper();

    String json = "{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\"}";

    Tweet tweet = objectMapper.readValue(json, Tweet.class);

    assertThat(tweet.author()).isEqualTo("@artem_zin");
    assertThat(tweet.content()).isEqualTo("Immutability for everybody!");
  }

  private ObjectMapper getObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(MapperFeature.AUTO_DETECT_CREATORS);
    objectMapper.disable(MapperFeature.AUTO_DETECT_FIELDS);
    objectMapper.disable(MapperFeature.AUTO_DETECT_SETTERS);
    objectMapper.disable(MapperFeature.AUTO_DETECT_GETTERS);
    objectMapper.disable(MapperFeature.AUTO_DETECT_IS_GETTERS);
    objectMapper.disable(MapperFeature.USE_GETTERS_AS_SETTERS);
    objectMapper.disable(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    objectMapper.disable(MapperFeature.INFER_PROPERTY_MUTATORS);
    objectMapper.disable(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS);
    return objectMapper;
  }
}
