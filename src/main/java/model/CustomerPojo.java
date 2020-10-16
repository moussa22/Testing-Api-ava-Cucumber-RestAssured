package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerPojo {
    private String firstName;
    private String lastName;
    private String phone;
   List<String>  addresses;
}
