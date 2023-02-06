import sys
import requests


def scrape_account(id: str) -> object:
    
    r = requests.get(url = "http://localhost:8080/api/user/search/" + id.strip())

    if r.status_code == 200:
        return r.json()
    
    return None


file_name = sys.argv[1]
account_list = open(file_name, 'r')

for account in account_list:
    info = scrape_account(account)
    if info is not None:
        print("{}".format(info))
  
account_list.close()