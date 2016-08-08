import { provideRouter, RouterConfig } from '@angular/router';

import { HomeRoutes } from './+home/home.routes';
import { ShopRoutes } from './+shop/shop.routes';
import { LocationRoutes } from './+locations/locations.routes';
import { ShippingRoutes } from './+shipping/shipping.routes';
import { LicenseRoutes } from './shared/license/license.routes';

const routes: RouterConfig = [
  ...HomeRoutes,
  ...ShopRoutes,
  ...LocationRoutes,
  ...ShippingRoutes,
  ...LicenseRoutes,
];

export const APP_ROUTER_PROVIDERS = [
  provideRouter(routes),
];