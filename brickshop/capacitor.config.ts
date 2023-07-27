import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'com.brickshop',
  appName: 'brickshop',
  webDir: 'build',
  server: {
    androidScheme: 'https'
  }
};

export default config;
