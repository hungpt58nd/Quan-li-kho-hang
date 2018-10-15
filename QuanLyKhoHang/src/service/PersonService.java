/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import quanlykhohang.model.PersonEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Storm Spirit
 */
public class PersonService {
    private FileUtil fileUtil;

    public PersonService(String fileName) throws IOException {
        fileUtil = new FileUtil(fileName);
    }

    public void save(List<PersonEntity> personEntity) throws IOException {
        List<String> data = new ArrayList<>();

        for(PersonEntity person: personEntity){
            data.add(person.toString());
        }

        fileUtil.writeData(data);
    }

    public List convertData() throws IOException {
        List<PersonEntity> personEntities = new ArrayList<>();

        List<String[]> dataFromFile = fileUtil.readData();
        for(String[] arr: dataFromFile){
            PersonEntity personEntity = new PersonEntity();
            personEntity.name = arr[0];
            personEntity.address = arr[1];
            personEntity.phone = arr[2];
            personEntity.createdAt = arr[3];
            personEntity.total = Integer.parseInt(arr[4]);
            personEntity.note = arr[5];

            personEntities.add(personEntity);
        }

        return personEntities;
    }
    
}
