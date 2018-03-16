package com.artemzin.autojackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.NotNull;

@AutoValue
@JsonDeserialize(builder = Tweet.Builder.class)
@JsonSerialize(as = Tweet.class)
public abstract class Tweet {

  @NotNull
  public static Builder builder() {
    return Builder.builder();
  }

  @NotNull
  @JsonProperty("author")
  public abstract String author();

  @NotNull
  @JsonProperty("content")
  public abstract String content();

  @AutoValue.Builder
  public static abstract class Builder {
    @JsonCreator
    public static Builder builder() {
      return new AutoValue_Tweet.Builder();
    }
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