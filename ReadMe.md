JDK Used: 11.0.4

This Application is used to plot equidistant path(50 metres) between given Source and Destination Points.

The major components include:
1) AppController: Used to get Request and send Response.
The server port running this application is 8181
2) AppService: Contains the Business logic whch is used to Plot the points
3) GeoApiService: To communicate with Google Directions API
4) AppUtils: Utility Functions to plot the equidistant points

Running the Application:
To run the Application, start the LocusLocationAssignmentApplication class

Sample Request:
The Server is running at port 8181.
URL: http://localhost:8181/route  (POST)
Request Body:  { 
                   "source": { "lat": "12.912710", "lng": "77.710510" }, 
                   "dest": { "lat": "12.915628", "lng": "77.721958" } 
               }
               
Sample Response:
{
    "response": [
        {
            "lat": 12.912600000000001,
            "lng": 77.71053
        },
        {
            "lat": 12.912666711674495,
            "lng": 77.71098622177396
        },
        {
            "lat": 12.912733423357698,
            "lng": 77.71144244360748
        },
        {
            "lat": 12.91280013504961,
            "lng": 77.71189866550054
        },
        {
            "lat": 12.912866846750227,
            "lng": 77.71235488745316
        },
        {
            "lat": 12.912926758881929,
            "lng": 77.7128120025253
        },
        {
            "lat": 12.91285349180762,
            "lng": 77.71325952457715
        },
        {
            "lat": 12.912640166051608,
            "lng": 77.71366545628736
        },
        {
            "lat": 12.912425172706918,
            "lng": 77.71407063605236
        },
        {
            "lat": 12.912242507703697,
            "lng": 77.71448758474067
        },
        {
            "lat": 12.912561222521482,
            "lng": 77.71476849446697
        },
        {
            "lat": 12.912957321023026,
            "lng": 77.71498685646142
        },
        {
            "lat": 12.91335385936744,
            "lng": 77.7152043758803
        },
        {
            "lat": 12.91374544329319,
            "lng": 77.71543064211706
        },
        {
            "lat": 12.914075209203881,
            "lng": 77.71573706542277
        },
        {
            "lat": 12.914360238506717,
            "lng": 77.71609383105262
        },
        {
            "lat": 12.9146351365152,
            "lng": 77.71645882252074
        },
        {
            "lat": 12.914908708811263,
            "lng": 77.71682494508168
        },
        {
            "lat": 12.915131593270905,
            "lng": 77.71722540202916
        },
        {
            "lat": 12.915367945533612,
            "lng": 77.7176176631942
        },
        {
            "lat": 12.915624539192661,
            "lng": 77.71799590095047
        },
        {
            "lat": 12.915845506796352,
            "lng": 77.71839454611703
        },
        {
            "lat": 12.915837094806365,
            "lng": 77.71884542044432
        },
        {
            "lat": 12.915761426861183,
            "lng": 77.71929857712941
        },
        {
            "lat": 12.915641788619666,
            "lng": 77.71974295677416
        },
        {
            "lat": 12.915542387843923,
            "lng": 77.72019287607489
        },
        {
            "lat": 12.915482731143404,
            "lng": 77.7206480656979
        },
        {
            "lat": 12.915565360093224,
            "lng": 77.72109786697742
        },
        {
            "lat": 12.915672373881796,
            "lng": 77.72154100894565
        }
    ]
}