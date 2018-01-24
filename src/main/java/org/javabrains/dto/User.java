package org.javabrains.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Karen on 06-Jul-17.
 */

@Entity(name = "user")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Temporal(TemporalType.DATE)
    private Date joinedDate;

    @Lob
    private String description;

//    @Embedded
//    private Address address;
//
    @ElementCollection(/*fetch = FetchType.EAGER*/)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"))
//    @GenericGenerator(name = "native", strategy = "native")
//    @CollectionId(columns = {@Column(name = "address_id")},
//            generator = "native", type = @Type(type = "long"))
    Collection<Address> addressSet = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

//    @OneToMany
//    @JoinTable(joinColumns = @JoinColumn(name="user_id"),
//            inverseJoinColumns = @JoinColumn(name = "book_id"))
//    private Collection<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Collection<Book> books = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_house",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id"))
    private Collection<House> houses = new ArrayList<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }


    public Collection<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Collection<Address> addressSet) {
        this.addressSet = addressSet;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public Collection<House> getHouses() {
        return houses;
    }

    public void setHouses(Collection<House> houses) {
        this.houses = houses;
    }
}
