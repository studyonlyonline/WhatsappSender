/**
 * Libraries required - selenium-java-3.141.59/client-combined-3.141.59 jar and chromedriver for selenium compatible with your chrome version
 *
 * To run this whatsapp sender  -
 * For mac run this command in terminal , this opens chrome in debig mode at port 9222
 * /Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --remote-debugging-port=9222 --no-first-run --no-default-browser-check --user-data-dir=$(mktemp -d -t 'chrome-remote_data_dir')
 *
 * For other operating system check command online and run chrome in debug mode at port 9222
 *
 * Running above command will open new Chrome window
 * Open web.whatsapp in it and login using QR code (required only once)
 * Now run the script anytime you want to send the whatsapp message
 *
 * Whatsapp API to be used - "https://web.whatsapp.com/send?phone="+ PhoneNo +"&text=" + text +"&source&data&app_absent";
 * Replace phone no with mobile no and text with the message you want to send
 */


/**
 * Send whatsapp message from a CSV file containing phone nums only
 */
