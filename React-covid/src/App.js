import React, {Component} from 'react';
import { BrowserRouter as Router, Route,Switch } from 'react-router-dom';
import {Redirect} from 'react-router-dom';

import Stats from './Components/Stats'
import Nav from './Components/Nav'
import Contact from './Components/Contact'
import './App.css';

class App extends Component  {
  render(){
    return (
      <Router>
      <Switch>
        <Route exact path="/">

      <div className = "App">
        <Nav />
        <center><h1>Covid 19 Status:</h1>
        <h3>COVID is a rapidly increasing deadly disease which has taken millions of lives.Coronavirus disease 2019 (COVID-19), also known as the coronavirus or COVID, is a contagious disease caused by severe acute respiratory syndrome coronavirus 2 (SARS-CoV-2). The first known case was identified in Wuhan, China, in December 2019. The disease has since spread worldwide, leading to an ongoing pandemic.</h3>
                <h2>State-wise details are as follows:</h2></center>
        <Stats prov="Tamil Nadu"/>
        <Stats prov="Kerala"/>
        <Stats prov="Puducherry"/>
        <Stats prov="Telangana"/>
      </div>

      </Route>

      <Route exact path="/contact">
      <div className = "App">
        <Nav />
        <Contact />
      </div>
      </Route>
    </Switch>
    </Router>
    );
  }
}

export default App;
