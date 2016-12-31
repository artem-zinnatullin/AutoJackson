package com.artemzin.autojackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

@AutoValue
@JsonDeserialize(builder = AutoValue_Tweet.Builder.class)
public abstract class Tweet {

  public static Builder builder() {
    return new AutoValue_Tweet.Builder();
  }

  @JsonProperty("author")
  public abstract String author();

  @JsonProperty("content")
  public abstract String content();

  @Nullable
  public abstract Boolean blocked();

  @AutoValue.Builder
  public static abstract class Builder {

    @JsonProperty("author")
    public abstract Builder author(String author);

    @JsonProperty("content")
    public abstract Builder content(String content);

    public abstract Builder blocked(Boolean blocked);

    public abstract Boolean blocked();

    public abstract Tweet autoBuild();

    public Tweet build() {
      if (blocked() == null) {
        blocked(false);
      }
      return autoBuild();
    }
  }
}