package com.artemzin.autojackson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.NotNull;

@AutoValue
@JsonDeserialize(builder = AutoValue_Tweet.Builder.class)
public abstract class Tweet {

  @NotNull
  public static Builder builder() {
    return new AutoValue_Tweet.Builder();
  }

  @NotNull
  public abstract String author();

  @NotNull
  public abstract String content();

  @AutoValue.Builder
  @JsonPOJOBuilder(withPrefix = "set")
  public static abstract class Builder {
    @NotNull
    public abstract Builder author(@NotNull String author);

    @NotNull
    public abstract Builder content(@NotNull String content);

    @NotNull
    public abstract Tweet build();
  }
}
