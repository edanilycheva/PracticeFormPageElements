package models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors

public class StateAndCity {

    private String city;
    private String state;

    public enum TypeOfState {
        FROM_NCR,
        FROM_UTTAR,
        FROM_HARYANA

    }

    public StateAndCity(TypeOfState typeOfState) {
        switch (typeOfState) {
            case FROM_NCR -> {
                this.state = "NCR";
                this.city = "Delhi";
            }
            case FROM_UTTAR -> {
                this.state = "Uttar Pradesh";
                this.city = "Agra";
            }
            case FROM_HARYANA -> {
                this.state = "Haryana";
                this.city = "Karnal";
            }

        }
    }

}
