package org.example.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
public class AddEmployeeresponse {

    public AddEmployeeresponse(String response) {
        this.response = response;
    }

    @JsonProperty("response")
    private String response;


    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
