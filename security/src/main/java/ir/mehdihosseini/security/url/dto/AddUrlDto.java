package ir.mehdihosseini.security.url.dto;

import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;

public record AddUrlDto(@DefaultValue(value = "false") boolean permitAll , String title, String path, String contextPath) implements Serializable {
}
