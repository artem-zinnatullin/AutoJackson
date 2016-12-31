package com.artemzin.autojackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AutoValue
@JsonDeserialize(builder = AutoValue_Tweet.Builder.class)
public abstract class Tweet {

  @NotNull
  @JsonCreator
  public static Builder builder() {
    return new AutoValue_Tweet.Builder().blocked(false);
  }

  @NotNull
  @JsonProperty("author")
  public abstract String author();

  @NotNull
  @JsonProperty("content")
  public abstract String content();

  @Nullable
  @JsonIgnore
  public abstract Boolean blocked();

  @AutoValue.Builder
  public static abstract class Builder {
    @NotNull
    @JsonProperty("author")
    public abstract Builder author(@NotNull String author);

    @NotNull
    @JsonProperty("content")
    public abstract Builder content(@NotNull String content);

    @JsonIgnore
    public abstract Builder blocked(@NotNull Boolean blocked);

    @Nullable
    @JsonIgnore
    public abstract Boolean blocked();

    @NotNull
    public abstract Tweet autoBuild();

    public Tweet build() {
      if (blocked() == null) {
        blocked(false);
      }
      return autoBuild();
    }
  }
}