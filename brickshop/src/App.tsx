import React, { useEffect, useState } from 'react';
import { Redirect, Route } from 'react-router-dom';
import { IonApp, IonRouterOutlet, setupIonicReact } from '@ionic/react';
import { IonReactRouter } from '@ionic/react-router';
import Home from './pages/Home';

/* Core CSS required for Ionic components to work properly */
import '@ionic/react/css/core.css';

/* Basic CSS for apps built with Ionic */
import '@ionic/react/css/normalize.css';
import '@ionic/react/css/structure.css';
import '@ionic/react/css/typography.css';

/* Optional CSS utils that can be commented out */
import '@ionic/react/css/padding.css';
import '@ionic/react/css/float-elements.css';
import '@ionic/react/css/text-alignment.css';
import '@ionic/react/css/text-transformation.css';
import '@ionic/react/css/flex-utils.css';
import '@ionic/react/css/display.css';
 
/* Theme variables */
import './theme/variables.css';
import { CatalogContext } from './context';
import { Product } from './model';
import { CatalogService } from './services';

setupIonicReact(); 

const App: React.FC = () => {  
  const [products, setProducts] = useState<Product[]>([]) 
  useEffect(() => {
    (async () =>{
      const products = await CatalogService.getProducts();
      setProducts(products);
    })()
  }, [])
  
  return (    
    <CatalogContext.Provider value={{products: products, setProducts: setProducts}}>
      <IonApp>
        <IonReactRouter>
          <IonRouterOutlet>
            <Route exact path="/home">
              <Home />
            </Route>
            <Route exact path="/">
              <Redirect to="/home" />
            </Route>
          </IonRouterOutlet>
        </IonReactRouter>
      </IonApp>
    </CatalogContext.Provider>
  )
};

export default App;
