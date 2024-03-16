package org.example.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class DeleteEmployeeresponse {

    @JsonProperty("response")
    private String response;

    public String getResponse() {
        return response;
    }

    public DeleteEmployeeresponse(String response) {
        this.response = response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
