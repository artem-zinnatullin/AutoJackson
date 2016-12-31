package com.artemzin.autojackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@AutoValue
@JsonDeserialize(builder = AutoValue_Tweet.Builder.class)
public abstract class Tweet {

  @Nonnull
  @JsonCreator
  public static Builder builder() {
    return new AutoValue_Tweet.Builder().blocked(false);
  }

  @Nonnull
  @JsonProperty("author")
  public abstract String author();

  @Nonnull
  @JsonProperty("content")
  public abstract String content();

  @Nullable
  public abstract Boolean blocked();

  @AutoValue.Builder
  public static abstract class Builder {
    @Nonnull
    @JsonProperty("author")
    public abstract Builder author(@Nonnull String author);

    @Nonnull
    @JsonProperty("content")
    public abstract Builder content(@Nonnull String content);

    @Nullable
    public abstract Builder blocked(@Nonnull Boolean blocked);

    public abstract Boolean blocked();

    @Nonnull
    public abstract Tweet autoBuild();

    public Tweet build() {
      if (blocked() == null) {
        blocked(false);
      }
      return autoBuild();
    }
  }
}