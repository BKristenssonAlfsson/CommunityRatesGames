package com.communityratesgames.dao;

import com.communityratesgames.domain.*;
import com.communityratesgames.model.CompanyModel;
import com.communityratesgames.transactions.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CRGDataAccess implements DataAccessLocal, DataAccessRemote {

    //Injects to all interfaces for each entity

    @Inject
    private CompanyDataAccess companyDataAccess;

    @Inject
    private GameDataAccess gameDataAccess;

    @Inject
    private PlatformDataAccess platformDataAccess;

    @Inject
    private RatingDataAccess ratingDataAccess;

    @Inject
    private UserDataAccess userDataAccess;

    public Company registerNewCompany(CompanyModel companyModel){ return companyDataAccess.registerNewCompany(companyModel); }
    public List<Platform> showAllPlatforms() {return platformDataAccess.showAllPlatforms();}
    public List<User> showAllUsers() {return userDataAccess.showAllUsers();}
    public User login(String email, String password) {return userDataAccess.login(email, password);}

    //Game Access
    public List<Game> showAllGames() {return gameDataAccess.showAllGames();}
    public Game gameByTitle(String title) {
        return gameDataAccess.gameByTitle(title);
    }
    public Game gameById(Long id) {
        return gameDataAccess.gameById(id);
    }
    public String searchFiveGames(String query) {
        return gameDataAccess.searchFiveGames(query);
    }


    public User register(String username, String email, String password) {return userDataAccess.register(username, password, email);}
    public List<Rating> showAllRatings() {return  ratingDataAccess.showAllRatings();}
    public List<Company> showAllCompanies() {return companyDataAccess.showAllCompanies();}
}
