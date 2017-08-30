package com.jingge.dw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jingge.dw.api.Rocket;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;

/**
 * Created by lordukthar on 2017-08-30.
 */
public class Runner {


    @Test
    public void getRocket() {

        try {

        Client client = Client.create();


        WebResource webResource = client
                .resource("http://localhost:8080/noop/df");


        ClientResponse response = webResource.
                        header("Content-Type",
                                "application/json;charset=UTF-8")
                .header("SDSD", "HKJHJKHJ")
                        .accept("application/json")
                        .get(ClientResponse.class);


        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

            Rocket output = response.getEntity(Rocket.class);
            System.out.println("Output from Server .... \n");
            System.out.println(output.getColor());






        } catch (Exception e) {

        e.printStackTrace();

        }
    }

    @Test
    public void postRocket() {

        try {


            Client client = Client.create();


            WebResource webResource = client
                    .resource("http://localhost:8080/noop/");

            ObjectMapper mapper = new ObjectMapper();
            Rocket obj = new Rocket();
            obj.setYear(2000);
            obj.setName("kjlkl");
            obj.setColor("yellow");

            String jsonInString = mapper.writeValueAsString(obj);

            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, jsonInString);


            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);



            System.out.println("Output from Server .... \n");








        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}

