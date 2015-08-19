# AutoJackson
Simple example of class annotated with [AutoValue](https://github.com/google/auto/tree/master/value) and [AutoParcel](https://github.com/frankiesardo/auto-parcel) + [Jackson](https://github.com/FasterXML/jackson).

It is **serializable** to JSON and **deserializable** from JSON.

```java
// Just use @AutoParcel annotations if you need AutoParcel

@AutoValue
@JsonDeserialize(builder = AutoValue_Tweet.Builder.class)
public abstract class Tweet {

  @NotNull
  public static Builder builder() {
    return new AutoValue_Tweet.Builder();
  }

  @NotNull
  @JsonProperty("author")
  public abstract String author();

  @NotNull
  @JsonProperty("content")
  public abstract String content();

  @AutoValue.Builder
  public static abstract class Builder {
  
    @NotNull
    @JsonProperty("author")
    public abstract Builder author(@NotNull String author);

    @NotNull
    @JsonProperty("content")
    public abstract Builder content(@NotNull String content);

    @NotNull
    public abstract Tweet build();
  }
}
```

**Serialization** and **deserialization**:

```java
@Test
public void shouldSerializeToJson() throws JsonProcessingException {
  ObjectMapper objectMapper = new ObjectMapper();

  Tweet tweet = Tweet.builder()
    .author("@artem_zin")
    .content("Immutability for everybody!")
    .build();

  assertThatJson(objectMapper.writeValueAsString(tweet))
    .isEqualTo("{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\"}");
}

@Test
public void shouldDeserializeFromJson() throws IOException {
  ObjectMapper objectMapper = new ObjectMapper();

  String json = "{\"author\":\"@artem_zin\",\"content\":\"Immutability for everybody!\"}";

  Tweet tweet = objectMapper.readValue(json, Tweet.class);

  assertThat(tweet.author()).isEqualTo("@artem_zin");
  assertThat(tweet.content()).isEqualTo("Immutability for everybody!");
}
```

#### Build the project
Run `sh ci.sh`.

#### Contact me
https://twitter.com/artem_zin
